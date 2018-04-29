package pl.godziatkowski.AgentGodzioServer.domain.borrowevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface BorrowEventRepository extends JpaRepository<BorrowEvent, Long> {
}
