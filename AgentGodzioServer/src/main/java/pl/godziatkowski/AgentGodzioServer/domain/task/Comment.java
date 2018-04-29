package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;
    private long commenter;
    private String message;

    CommentDto toDto(){
        return new CommentDto(id, commenter, message);
    }
}
