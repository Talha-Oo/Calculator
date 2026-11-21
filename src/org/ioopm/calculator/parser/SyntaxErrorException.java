package org.ioopm.calculator.parser;
public class SyntaxErrorException extends RuntimeException {

    /**
     * Creates a syntax error exception without a specific error message.
    */
    public SyntaxErrorException() {
        super();
    }

    /**
     * Creates a syntax error exception with a specific error message.
     * @param msg the error message describing the syntax error
    */
    public SyntaxErrorException(String msg) {
        super(msg);
    }
}