package pl.godziatkowski.AgentGodzioServer.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface UserRepository extends JpaRepository<Long, User>{
}
