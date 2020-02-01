package fr.emile.todoCore.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PARTIAL_CONTENT)
public class NothingToDoException extends RuntimeException {
        private String message;
        public NothingToDoException( String message){
            super(String.format("Nothing to do : %s", message));
            this.message = message;
        }

    public String getMessage() {
        return message;
    }
}

