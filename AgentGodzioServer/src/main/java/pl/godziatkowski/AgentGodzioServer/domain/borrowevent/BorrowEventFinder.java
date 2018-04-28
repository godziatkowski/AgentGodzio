package pl.godziatkowski.AgentGodzioServer.domain.borrowevent;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BorrowEventFinder {

    private final BorrowEventRepository borrowEventRepository;

}
