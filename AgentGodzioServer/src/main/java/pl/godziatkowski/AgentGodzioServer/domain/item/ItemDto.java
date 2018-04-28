package pl.godziatkowski.AgentGodzioServer.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {
    private final Long id;
    private final String name;
    private final String description;
    private final String category;
}
