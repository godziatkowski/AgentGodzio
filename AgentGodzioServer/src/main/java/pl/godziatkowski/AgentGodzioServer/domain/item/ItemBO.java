package pl.godziatkowski.AgentGodzioServer.domain.item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemBO {

    private final ItemRepository itemRepository;

}
