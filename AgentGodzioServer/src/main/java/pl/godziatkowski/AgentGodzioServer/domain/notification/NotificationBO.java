package pl.godziatkowski.AgentGodzioServer.domain.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationBO {

    private final NotificationRepository notificationRepository;
}
