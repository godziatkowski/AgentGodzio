package pl.godziatkowski.AgentGodzioServer.domain.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentFinder {
    private final CommentRepository commentRepository;
}
