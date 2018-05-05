package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.godziatkowski.AgentGodzioServer.error.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserFinder {
    private final UserRepository userRepository;

    public UserDto findByName(String name){
        Optional<User> userOptional = userRepository.findOneByName(name);
        userOptional.orElseThrow(() -> new NotFoundException(String.format(UserRepository.USER_NOT_FOUND_BY_NAME, name)));
        return userOptional.get().toDto();
    }
}
