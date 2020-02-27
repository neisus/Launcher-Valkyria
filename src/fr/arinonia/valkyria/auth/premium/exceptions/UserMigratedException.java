package fr.arinonia.valkyria.auth.premium.exceptions;

import fr.arinonia.valkyria.auth.premium.responses.ErrorResponse;

public class UserMigratedException extends RequestException {
    public UserMigratedException(ErrorResponse error) {
        super(error);
    }
}
