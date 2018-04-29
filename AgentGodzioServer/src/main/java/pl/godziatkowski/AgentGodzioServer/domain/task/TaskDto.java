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
    private Long id;
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
