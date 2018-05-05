package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@Data
@Entity
class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    private String name;

    @Column(nullable = false, length = 10)
    private UserRole role;

    @Column(nullable = false, length = 25)
    private String password;

    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private Set<Long> newComments;

    public User() {
        this.newComments = new HashSet<>();
    }

    UserDto toDto(){
        return new UserDto(id, name, role, newComments);
    }
}
