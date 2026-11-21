package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {
  
  /**
   * Indicates whether this expression is a constant.
   * @return false by default
   */
  public boolean isConstant()
  {
    return false;
  }

  /**
   * Returns the name of the operator associated with this expression.
   * @return the operator name
   * @throws RuntimeException if the expression has no operator
  */
  public String getName()
  {
    throw new RuntimeException("getName() called on expression with no operator");
  }

  /**
   * Returns the operator priority of this expression.
   * @return 0 by default
  */
  public int getPriority()
  {
    return 0;
  }

  /**
   * Returns the value of this expression.
   * @return the value
   * @throws RuntimeException if the expression is not a constant
   */
  public double getValue()
  {
    throw new RuntimeException("getvalue() called on expression which is not a constant");
  }

  /**
   * Evaluates this symbolic expression using the supplied environment.
   * @param vars the environment containing variable values
   * @return the evaluated expression
  */
  public abstract SymbolicExpression eval(Environment vars);


  /**
   * Indicates whether this expression represents a command.
   * @return false by default
  */
  public boolean isCommand()
  {
    return false;
  }

  /**
   * Indicates whether this expression represents a named constant.
   * @return false by default
   */
  public boolean isNamedConstant()
  {
    return false;
  }
}
