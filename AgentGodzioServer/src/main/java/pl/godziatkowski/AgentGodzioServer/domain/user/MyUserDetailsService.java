package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.godziatkowski.AgentGodzioServer.error.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findOneByName(username);
        user.orElseThrow(() -> new NotFoundException(String.format(UserRepository.USER_NOT_FOUND_BY_NAME, username)));
        return new MyUserPrincipal(user.get());
    }
}
