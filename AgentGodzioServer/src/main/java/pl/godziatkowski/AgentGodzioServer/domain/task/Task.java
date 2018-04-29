package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
@Entity
class Task {
    @Id
    @GeneratedValue
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
            mappedBy = "task")
    private List<Comment> comments;

    TaskDto toDto() {
        List<CommentDto> commentDtos = comments.stream().map(Comment::toDto).collect(Collectors.toList());
        return new TaskDto(id, description, authorId, assignedTo, assignee, status, deadline, remindBefore, archived, linkedTasks, relatedUsers, commentDtos);
    }
}
