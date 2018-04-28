package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface TaskTemplateRepository extends JpaRepository<Long, TaskTemplate>{
}
