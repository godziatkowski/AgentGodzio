package pl.godziatkowski.AgentGodzioServer.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto {

    private final long id;

    private final String name;

    private final UserRole role;

    private final Set<Long> newComments;

    private String password;
}
