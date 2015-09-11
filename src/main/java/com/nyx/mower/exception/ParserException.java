package com.nyx.mower.exception;

public class ParserException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2880766698080239047L;

    public ParserException(String message, Exception e) {
        super(message, e);
    }
}
