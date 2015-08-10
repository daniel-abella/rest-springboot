package br.edu.embedded.zennyworldz.ws.service.exception;

public class ParticipantAlreadyExistsException extends RuntimeException {

    public ParticipantAlreadyExistsException(final String message) {
        super(message);
    }
}
