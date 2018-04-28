package pl.godziatkowski.AgentGodzioServer.domain.borrowevent;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BorrowEventBO {

    private final BorrowEventRepository borrowEventRepository;
}
