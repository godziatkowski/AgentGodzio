package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class CommentDto {
    private final Long id;
    private final long commenter;
    private final String message;
}
