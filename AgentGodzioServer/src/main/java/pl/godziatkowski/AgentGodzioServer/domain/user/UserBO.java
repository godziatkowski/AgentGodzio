package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.godziatkowski.AgentGodzioServer.error.NotFoundException;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class UserBO {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public long addUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .role(userDto.getRole())
                .password(securePassword(userDto.getPassword()))
                .build();
        user = userRepository.save(user);
        log.info("New User with id <{}> created", user.getId());
        return user.getId();
    }

    public void updateUser(long userId, UserDto userDto) {
        User user = getUser(userId);
        user.setName(userDto.getName());
        userRepository.save(user);
        log.info("Update data of User with id <{}>", user.getId());
    }

    public void changePassword(long userId, String password) {
        User user = getUser(userId);
        user.setPassword(securePassword(password));
        userRepository.save(user);
        log.info("Changed password for User with id <{}>", user.getId());
    }

    public void changeRole(long userId, UserRole userRole) {
        User user = getUser(userId);
        user.setRole(userRole);
        userRepository.save(user);
        log.info("Granted role <{}> to user with id <{}>", userRole, userId);
    }

    public void addCommentToRead(long userId, long commentId) {
        User user = getUser(userId);
        user.getNewComments().add(commentId);
        userRepository.save(user);
        log.info("User with id <{}> received new comment with id <{}>", userId, commentId);
    }

    public void removeDisplayedComment(long userId, Set<Long> commentIds) {
        User user = getUser(userId);
        user.getNewComments().removeAll(commentIds);
        userRepository.save(user);
        log.info("User with id <{}> displayed comment with ids <{}>", userId, commentIds);
    }

    private String securePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private User getUser(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.orElseThrow(() -> new NotFoundException(String.format(UserRepository.USER_NOT_FOUND_BY_ID, userId)));

        return userOptional.get();
    }

}
