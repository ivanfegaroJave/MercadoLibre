package com.co.fraud.crosscuting.exception;
/**
 * Class that overwrites exceptions
 *
 * @version		1.0.0
 * @author 		Iván García
 */
public final class ValidationException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 3215833037118051878L;

    /**
     * Constructor
     */
    public ValidationException() {
        super();
    }

    /**
     * Constructor
     * @param message text with the exception description
     */
    public ValidationException(final String message) {
        super(message);
    }

}
