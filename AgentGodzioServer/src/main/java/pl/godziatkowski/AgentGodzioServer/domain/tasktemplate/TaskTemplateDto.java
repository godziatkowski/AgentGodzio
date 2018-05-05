package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.godziatkowski.AgentGodzioServer.domain.task.TaskStatus;

import java.time.Period;
import java.util.Set;

@Getter
@AllArgsConstructor
public class TaskTemplateDto {
    private final long id;
    private final RepeatMode repeatMode;
    private final String description;
    private final long author;
    private final Set<Long> assignedTo;
    private final Period remindBefore;
    private final TaskStatus taskStatus;
    private final long assignee;

}
