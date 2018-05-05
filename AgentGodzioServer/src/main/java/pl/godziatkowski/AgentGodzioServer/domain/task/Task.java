package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@Entity
class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private long authorId;
    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private Set<Long> assignableTo;
    private long assignedTo;
    private TaskStatus status;
    private LocalDate deadline;
    private Period remindBefore;
    private boolean archived;
    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private Set<Long> linkedTasks;
    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private Set<Long> relatedUsers;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "task")
    private List<Comment> comments;

    public Task() {
        this.assignableTo = new HashSet<>();
        this.linkedTasks = new HashSet<>();
        this.relatedUsers = new HashSet<>();
    }

    TaskDto toDto() {
        List<CommentDto> commentDtos = comments.stream().map(Comment::toDto).collect(Collectors.toList());
        return new TaskDto(id, description, authorId, assignableTo, assignedTo, status, deadline, remindBefore, archived, linkedTasks, relatedUsers, commentDtos);
    }
}
