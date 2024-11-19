package com.icecreammachine.brtbonds.dao.exception;

/**
 * Represents Exceptions thrown by the Data Access Layer.
 */
public class DataAccessLayerException extends RuntimeException {

    private static final long serialVersionUID = 6612154926611857087L;

    // private static final Logger log = Logger.getLogger(DataAccessLayerException.class);

    public DataAccessLayerException() {}

    public DataAccessLayerException(String message) {
        super(message);
        // log.error(message);
    }

    public DataAccessLayerException(Throwable cause) {
        super(cause);
        // log.error("Error DataAcessLayerException ",cause);
    }

    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
        // log.error("Error DataAcessLayerException => "+ message,cause);
    }
}
