package pl.godziatkowski.AgentGodzioServer.domain.notification;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;

@Builder
@Data
@Entity
class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private NotificationTopic notificationTopic;
    private long topicId;
    private long recipient;
    private Duration frequency;
    private Duration sneeze;
}
