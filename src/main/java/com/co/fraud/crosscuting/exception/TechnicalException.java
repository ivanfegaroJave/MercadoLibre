package com.co.fraud.crosscuting.exception;

/**
 * Class that overwrites exceptions
 *
 * @author Iván García
 * @version 1.0.0
 */

public class TechnicalException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 3215833037118051878L;

    /**
     * Constructor
     *
     * @param message text with the exception description
     */
    public TechnicalException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message text with the exception description
     * @param cause   throw the cause of the error
     */
    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

}
