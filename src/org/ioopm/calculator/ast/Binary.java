package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
  private SymbolicExpression lhs;
  private SymbolicExpression rhs;

  /**
   * Creates a binary expression with a left-hand and right-hand operand.
   * @param lhs the left-hand operand
   * @param rhs the right-hand operand
  */
  public Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  /**
   * Returns the left-hand operand.
   * @return the left-hand operand
  */
  public SymbolicExpression getLhs() {
    return lhs;
  }

  /**
   * Returns the right-hand operand.
   * @return the right-hand operand
  */
  public SymbolicExpression getRhs() {
    return rhs;
  }

  private boolean lhsNeedParentheses() {
    return lhs.getPriority() < this.getPriority();
  }

  private String printLhs() {
    if (lhsNeedParentheses()) {
      return "(" + lhs.toString() + ")";
    }

    return lhs.toString();
  }

  private boolean rhsNeedParentheses() {
    int prioRhs = rhs.getPriority();
    int prioParent = this.getPriority();
    String operator = this.getName();

    if (rhs.getPriority() < this.getPriority()) {
      return true;
    }

    if (prioRhs == prioParent) {
      if (operator.equals("-")) {
        return true;
      } else if (operator.equals("/") && (rhs.getName().equals("*") || rhs.getName().equals("/"))) {
        return true;
      }
    }

    return false;
  }

  private String printRhs() {
    if (rhsNeedParentheses()) {
      return "(" + rhs.toString() + ")";
    }

    return rhs.toString();
  }

  /**
   * Checks whether this expression is equal to another object.
   * @param other the object to compare with
   * @return true if the object is a binary expression with the same operator and operands, otherwise false
  */
  public boolean equals(Object other) {
    if (other instanceof Binary) {
      return this.equals((Binary) other);
    } else {
      return false;
    }
  }

  /**
   * Checks whether two binary expressions have the same operator and operands.
   * @param other the binary expression to compare with
   * @return true if both expressions have the same operator and operands, otherwise false
  */
  public boolean equals(Binary other) {
    if (this.getName().equals(other.getName())) {
      return this.rhs.equals(other.rhs) && this.lhs.equals(other.lhs);
    }

    return false;
  }

  /**
   * Returns a string representation of the binary expression, including parentheses when needed.
   * @return the formatted expression as a string
   */
  public String toString() {
    String operator = this.getName();
    return printLhs() + " " + operator + " " + printRhs();
  }
}
