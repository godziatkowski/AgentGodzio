package pl.godziatkowski.AgentGodzioServer.domain.user;

import java.util.Set;

public class UserDtoTestBuilder {

    private Long id;

    private String name;

    private UserRole role;

    private Set<Long> newComments;

    private String password;

    public static UserDtoTestBuilder userDto() {
        return new UserDtoTestBuilder();
    }

    public UserDtoTestBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserDtoTestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserDtoTestBuilder setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public UserDtoTestBuilder setNewComments(Set<Long> newComments) {
        this.newComments = newComments;
        return this;
    }

    public UserDtoTestBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDto buildDto() {
        return new UserDto(id, name, role, newComments, password);
    }
}
