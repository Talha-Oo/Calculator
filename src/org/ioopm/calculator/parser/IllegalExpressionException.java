package org.ioopm.calculator.parser;
public class IllegalExpressionException extends RuntimeException {

    /**
     * Creates an exception without a specific error message.
    */

    public IllegalExpressionException() {
        super();
    }

    /**
     * Creates an exception with a specific error message.
     * @param msg the error message describing the illegal expression
     */
    public IllegalExpressionException(String msg) {
        super(msg);
    }
}