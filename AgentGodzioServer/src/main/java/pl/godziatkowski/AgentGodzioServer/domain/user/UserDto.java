package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class UserDto {

    private long id;

    private String name;

    private UserRole role;

    private Set<Long> newComments;
}
