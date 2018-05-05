package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.godziatkowski.AgentGodzioServer.error.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserFinder {
    private final UserRepository userRepository;

    public UserDto findOneById(long userId) {
        return getUser(userId).toDto();
    }

    public UserDto findByName(String name){
        Optional<User> userOptional = userRepository.findOneByName(name);
        userOptional.orElseThrow(() -> new NotFoundException(String.format(UserRepository.USER_NOT_FOUND_BY_NAME, name)));
        return userOptional.get().toDto();
    }

    public List<UserDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());

    }

    private User getUser(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.orElseThrow(() -> new NotFoundException(String.format(UserRepository.USER_NOT_FOUND_BY_ID, userId)));

        return userOptional.get();
    }
}
