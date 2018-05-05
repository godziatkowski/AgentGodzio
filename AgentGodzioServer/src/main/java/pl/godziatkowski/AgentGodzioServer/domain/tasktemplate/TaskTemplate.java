package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import lombok.Builder;
import lombok.Data;
import pl.godziatkowski.AgentGodzioServer.domain.task.TaskStatus;

import javax.persistence.*;
import java.time.Period;
import java.util.HashSet;
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
    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private Set<Long> assignableTo;
    private Period remindBefore;
    private TaskStatus taskStatus;
    private Long assignedTo;

    public TaskTemplate() {
        this.assignableTo = new HashSet<>();
    }

    TaskTemplateDto toDto() {
        return new TaskTemplateDto(id, repeatMode, description, author, assignableTo, remindBefore, taskStatus, assignedTo);
    }
}
