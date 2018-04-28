package pl.godziatkowski.AgentGodzioServer.domain.tasktemplate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskTemplateBO {

    private final TaskTemplateRepository taskTemplateRepository;
}
