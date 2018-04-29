package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@Builder
@Data
@Entity
class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private long authorId;
    private Set<Long> assignedTo;
    private long assignee;
    private TaskStatus status;
    private LocalDate deadline;
    private Period remindBefore;
    private boolean archived;
    private Set<Long> linkedTasks;
    private Set<Long> relatedUsers;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "goal")
    private List<CommentDto> comments;

}
