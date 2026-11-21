package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
  private SymbolicExpression expr;

  /**
   * Creates a unary expression with the specified operand.
   * @param expr the expression on which the unary operator acts
  */
  public Unary(SymbolicExpression expr) {
    this.expr = expr;
  }

  /**
   * Checks whether this expression is equal to another object.
   * @param other the object to compare with
   * @return true if the object is a unary expression with the same operator and operand, otherwise false
  */
  public boolean equals(Object other) 
  {
    if (other instanceof Unary) 
    {
      return this.equals((Unary) other);
    } 
    else 
    {
      return false;
    }
  }

  /**
   * Checks whether two unary expressions have the same operator and operand.
   * @param other the unary expression to compare with
   * @return true if both expressions have the same operator and operand, otherwise false
   */
  public boolean equals(Unary other) 
  {
    if(this.getName().equals(other.getName()))
    {
      return this.expr.equals(other.expr);
    }

    return false;
  }
  
  /**
   * Returns the operand of this unary expression.
   * @return the expression on which the operator acts
  */
  public SymbolicExpression getExpr()
  {
    return expr;
  }

  /**
   * Returns a string representation of the unary expression.
   * @return the operator name followed by the operand in parentheses
  */
  public String toString() {
    return this.getName() + "(" + this.expr.toString() + ")";
  }
}
