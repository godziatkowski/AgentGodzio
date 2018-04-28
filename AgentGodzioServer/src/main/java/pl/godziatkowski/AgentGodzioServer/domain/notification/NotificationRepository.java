package pl.godziatkowski.AgentGodzioServer.domain.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface NotificationRepository extends JpaRepository<Long, Notification>{
}
