package pl.godziatkowski.AgentGodzioServer.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface ItemRepository extends JpaRepository<Long, Item>{
}
