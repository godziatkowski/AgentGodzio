package pl.godziatkowski.AgentGodzioServer.domain.borrowevent;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@Data
@Entity
class BorrowEvent {
    @Id
    @GeneratedValue
    private Long id;
    private long itemId;
    private String borrowedTo;
    private LocalDate borrowedAt;
    private LocalDate returnedAt;

    BorrowEventDto toDto(){
        return new BorrowEventDto(id, itemId, borrowedTo, borrowedAt, returnedAt);
    }

}
