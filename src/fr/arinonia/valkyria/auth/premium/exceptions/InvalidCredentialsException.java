package fr.arinonia.valkyria.auth.premium.exceptions;

import fr.arinonia.valkyria.auth.premium.responses.ErrorResponse;

public class InvalidCredentialsException extends RequestException{
    public InvalidCredentialsException(ErrorResponse error) {
        super(error);
    }
}
