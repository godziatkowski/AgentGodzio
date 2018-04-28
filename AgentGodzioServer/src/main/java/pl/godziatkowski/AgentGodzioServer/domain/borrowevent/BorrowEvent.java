package pl.godziatkowski.AgentGodzioServer.domain.borrowevent;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@Data
@Entity
class BorrowEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long itemId;
    private String borrowedTo;
    private LocalDate borrowedAt;
    private LocalDate returnedAt;

    BorrowEventDto toDto(){
        return new BorrowEventDto(id, itemId, borrowedTo, borrowedAt, returnedAt);
    }

}
