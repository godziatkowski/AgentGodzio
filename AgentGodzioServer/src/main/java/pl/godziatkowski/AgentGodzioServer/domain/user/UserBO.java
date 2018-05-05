package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBO {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public long addUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .role(userDto.getRole())
                .password(securePassword(userDto))
                .build();
        user = userRepository.save(user);
        log.info("New User with id <{}> created", user.getId());
        return user.getId();
    }

    private String securePassword(UserDto userDto) {
        return passwordEncoder.encode(userDto.getPassword());
    }

}
