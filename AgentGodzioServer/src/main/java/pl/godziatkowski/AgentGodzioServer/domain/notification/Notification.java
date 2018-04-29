package pl.godziatkowski.AgentGodzioServer.domain.notification;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Duration;

@Builder
@Data
@Entity
class Notification {
    @Id
    @GeneratedValue
    private Long id;
    private NotificationTopic notificationTopic;
    private long topicId;
    private long recipient;
    private Duration frequency;
    private Duration sneeze;

    NotificationDto toDto(){
        return new NotificationDto(id, notificationTopic, topicId, recipient, frequency, sneeze);
    }
}
