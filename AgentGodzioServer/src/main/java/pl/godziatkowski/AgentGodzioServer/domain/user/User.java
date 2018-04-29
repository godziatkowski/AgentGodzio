package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Builder
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private UserRole role;

    private Set<Long> newComments;

    UserDto toDto(){
        return new UserDto(id, name, role, newComments);
    }
}
