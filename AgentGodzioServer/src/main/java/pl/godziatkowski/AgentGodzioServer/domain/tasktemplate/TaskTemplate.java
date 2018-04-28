package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import lombok.Builder;
import lombok.Data;
import pl.godziatkowski.AgentGodzioServer.domain.task.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Period;
import java.util.Set;

@Builder
@Data
@Entity
class TaskTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private RepeatMode repeatMode;
    private String description;
    private long author;
    private Set<Long> assignedTo;
    private Period remindBefore;
    private TaskStatus taskStatus;
    private Long assignee;

    TaskTemplateDto toDto() {
        return new TaskTemplateDto(id, repeatMode, description, author, assignedTo, remindBefore, taskStatus, assignee);
    }
}
