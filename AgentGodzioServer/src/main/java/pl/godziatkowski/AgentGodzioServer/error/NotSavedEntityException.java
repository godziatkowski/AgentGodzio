package pl.godziatkowski.AgentGodzioServer.error;

public class NotSavedEntityException extends RuntimeException{
    public NotSavedEntityException(String message) {
        super(message);
    }
}
