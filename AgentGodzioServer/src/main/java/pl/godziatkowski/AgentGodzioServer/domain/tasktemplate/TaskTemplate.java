package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import lombok.AllArgsConstructor;
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
    @Builder.Default
    private Set<Long> assignableTo = new HashSet<>();
    private Period remindBefore;
    private TaskStatus taskStatus;
    private Long assignedTo;


    TaskTemplateDto toDto() {
        return new TaskTemplateDto(id, repeatMode, description, author, assignableTo, remindBefore, taskStatus, assignedTo);
    }
}
