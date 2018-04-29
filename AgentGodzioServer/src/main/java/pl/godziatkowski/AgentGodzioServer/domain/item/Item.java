package pl.godziatkowski.AgentGodzioServer.domain.item;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Data
@Entity
class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String category;

    ItemDto toDto(){
        return new ItemDto(id, name, description, category);
    }
}
