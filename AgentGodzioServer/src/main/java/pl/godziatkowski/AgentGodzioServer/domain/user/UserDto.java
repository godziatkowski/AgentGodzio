package pl.godziatkowski.AgentGodzioServer.domain.user;

import java.util.Set;

public class UserDto {

    private long id;

    private String name;

    private UserRole role;

    private Set<Long> newComments;
}
