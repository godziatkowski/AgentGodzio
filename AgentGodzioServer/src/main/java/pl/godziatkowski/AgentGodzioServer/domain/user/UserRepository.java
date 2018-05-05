package pl.godziatkowski.AgentGodzioServer.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
interface UserRepository extends JpaRepository<User, Long>{
    String USER_NOT_FOUND_BY_ID = "User with id %d not found";
    String USER_NOT_FOUND_BY_NAME = "User with id %s not found";

    Optional<User> findOneByName(String name);
}
