package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class MyUserPrincipal implements UserDetails {

    private final String username;
    private final String password;
    private final List<? extends GrantedAuthority> authorities;

    public MyUserPrincipal(User user) {
        this.username = user.getName();
        this.password = user.getPassword();
        this.authorities = Stream.of(user.getRole().name())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
