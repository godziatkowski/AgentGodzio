package pl.godziatkowski.AgentGodzioServer.domain.user;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import pl.godziatkowski.AgentGodzioServer.error.NotFoundException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static pl.godziatkowski.AgentGodzioServer.domain.user.UserDtoTestBuilder.userDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserBOTest {

    private static final String CLAZZ = UserBOTest.class.getSimpleName();

    @Autowired
    UserRepository repository;
    @Autowired
    UserBO bo;
    @Autowired
    PasswordEncoder passwordEncoder;

    private User existingUser;

    @Before
    public void setUp() {
        assertThat(repository.findAll()).isEmpty();
        existingUser = repository.save(User.builder()
                .name(CLAZZ)
                .password(CLAZZ)
                .role(UserRole.ADMIN)
                .build());
    }

    @After
    public void tearDown() {
        repository.delete(existingUser);
    }

    @Test
    public void shouldAddUser() {
        //given
        String stringValue = "String";
        UserRole userRole = UserRole.ADMIN;
        UserDto userDto = userDto()
                .setName(stringValue)
                .setRole(userRole)
                .setPassword(stringValue)
                .buildDto();
        //when
        long id = bo.addUser(userDto);
        //then
        User user = repository.findById(id).get();
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo(stringValue);
        assertThat(user.getRole()).isEqualTo(userRole);
        assertThat(user.getPassword()).isNotEqualTo(stringValue);
        assertThat(passwordEncoder.matches(stringValue, user.getPassword())).isTrue();
    }

    @Test
    public void shouldUpdateUser() {
        //given
        String newName = CLAZZ + 1;
        UserDto userDto = userDto().setName(newName).buildDto();
        //when
        bo.updateUser(existingUser.getId(), userDto);
        //then
        User user = getUpdatedUser();
        assertThat(user.getName()).isEqualTo(newName);
    }

    @Test
    public void updateUser_shouldThrowException_whenUserNotFound() {
        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> bo.updateUser(Long.MAX_VALUE, userDto().buildDto()));
    }

    @Test
    public void changePassword() {
        //given
        String newPassword = CLAZZ + 1;
        String oldPasswordHash = existingUser.getPassword();
        //when
        bo.changePassword(existingUser.getId(), newPassword);
        //then
        User user = getUpdatedUser();
        assertThat(user.getPassword()).isNotEqualTo(oldPasswordHash);
        assertThat(passwordEncoder.matches(newPassword, user.getPassword())).isTrue();
    }

    @Test
    public void changePassword_shouldThrowException_whenUserNotFound() {
        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> bo.changePassword(Long.MAX_VALUE, CLAZZ));
    }

    @Test
    public void changeRole() {
        //given
        UserRole newRole = UserRole.USER;
        //when
        bo.changeRole(existingUser.getId(), newRole);
        //then
        User user = getUpdatedUser();
        assertThat(user.getRole()).isEqualTo(newRole);
    }

    @Test
    public void changeRole_shouldThrowException_whenUserNotFound() {
        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> bo.changeRole(Long.MAX_VALUE, UserRole.ADMIN));
    }

    @Test
    public void addCommentToRead() {
        //given
        Long newCommentId = 10l;
        //when
        bo.addCommentToRead(existingUser.getId(), newCommentId);
        //then
        User user = getUpdatedUser();
        assertThat(user.getNewComments()).contains(newCommentId);
    }

    @Test
    public void addComment_shouldThrowException_whenUserNotFound() {
        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> bo.addCommentToRead(Long.MAX_VALUE, Long.MAX_VALUE));
    }

    @Test
    public void removeDisplayedComment() {
        //given
        List<Long> commentIds = LongStream.range(0, 10)
                .boxed()
                .collect(Collectors.toList());
        commentIds.forEach(id -> bo.addCommentToRead(existingUser.getId(), id));
        Set<Long> commentIdsToRemove = commentIds.stream()
                .filter(id -> id % 2 == 0)
                .collect(Collectors.toSet());
        //when
        bo.removeDisplayedComment(existingUser.getId(), commentIdsToRemove);
        //then
        User user = getUpdatedUser();
        assertThat(user.getNewComments()).doesNotContainAnyElementsOf(commentIdsToRemove);
    }

    @Test
    public void removeDisplayedComment_shouldThrowException_whenUserNotFound() {
        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> bo.removeDisplayedComment(Long.MAX_VALUE, new HashSet<>()));
    }

    private User getUpdatedUser() {
        return repository.findById(existingUser.getId()).get();
    }
}