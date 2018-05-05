package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private final String description;
    private final long authorId;
    private final Set<Long> assignableTo;
    private final long assignedTo;
    private final TaskStatus status;
    private final LocalDate deadline;
    private final Period remindBefore;
    private final boolean archived;
    private final Set<Long> linkedTasks;
    private final Set<Long> relatedUsers;
    private final List<CommentDto> comments;

}
