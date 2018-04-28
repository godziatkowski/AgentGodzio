package pl.godziatkowski.AgentGodzioServer.domain.borrowevent;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowEventDto {
    private final long id;
    private final long itemId;
    private final String borrowedTo;
    private final LocalDate borrowedAt;
    private final LocalDate returnedAt;

}
