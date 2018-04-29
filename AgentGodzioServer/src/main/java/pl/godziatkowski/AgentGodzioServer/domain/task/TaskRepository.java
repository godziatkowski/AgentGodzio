package pl.godziatkowski.AgentGodzioServer.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface TaskRepository extends JpaRepository<Task, Long>{
}
