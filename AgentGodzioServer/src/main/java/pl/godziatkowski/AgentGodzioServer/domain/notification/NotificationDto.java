package pl.godziatkowski.AgentGodzioServer.domain.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

@Getter
@AllArgsConstructor
class NotificationDto {
    private final long id;
    private final NotificationTopic notificationTopic;
    private final long topicId;
    private final long recipient;
    private final Duration frequency;
    private final Duration sneeze;
}
