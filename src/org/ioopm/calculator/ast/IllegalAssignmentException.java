package org.ioopm.calculator.ast;

public class IllegalAssignmentException extends RuntimeException {

  /**
   * Creates an exception for an illegal assignment.
   * @param message the error message describing the illegal assignment
  */
  public IllegalAssignmentException(String message)
  {
    super(message);
  }
}
