package fr.arinonia.valkyria.auth.premium.exceptions;

import fr.arinonia.valkyria.auth.premium.responses.ErrorResponse;

public class RequestException extends Exception {

    private ErrorResponse error;

    public RequestException(ErrorResponse error) {
        this.error = error;
    }

    public ErrorResponse getError() {
        return error;
    }
    public String getErrorMessage(){
        return this.error.getErrorMessage();
    }
    public String getErrorCause(){
        return this.error.getCause();
    }
}
