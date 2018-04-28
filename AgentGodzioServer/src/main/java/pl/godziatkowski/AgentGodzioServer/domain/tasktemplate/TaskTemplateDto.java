package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.godziatkowski.AgentGodzioServer.domain.task.TaskStatus;

import java.time.Period;
import java.util.Set;

@Getter
@AllArgsConstructor
public class TaskTemplateDto {
    private long id;
    private RepeatMode repeatMode;
    private String description;
    private long author;
    private Set<Long> assignedTo;
    private Period remindBefore;
    private TaskStatus taskStatus;
    private long assignee;

}
