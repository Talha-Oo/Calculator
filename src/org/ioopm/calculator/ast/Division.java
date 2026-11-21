package org.ioopm.calculator.ast;

import org.ioopm.calculator.parser.IllegalExpressionException;

/**
   * Creates a division expression with a numerator and denominator.
   * @param lhs the numerator
   * @param rhs the denominator
  */
public class Division extends Binary 
{
  public Division(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  /**
   * Returns the division operator, "/".
   * @return the string "/"
  */
  public String getName()
  {
    return "/";
  }

  /**
   * Returns the operator priority of division.
   * @return the priority value 2
  */
  public int getPriority() {
    return 2;
  }

  /**
   * Evaluates the division if both operands are constants. Otherwise, returns a new division 
   * expression with the evaluated operands.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated division expression
   * @throws IllegalExpressionException if the denominator evaluates to zero
  */
  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression lhs = super.getLhs().eval(vars);
    SymbolicExpression rhs = super.getRhs().eval(vars);

    if (lhs.isConstant() && rhs.isConstant()) 
    {
      if(rhs.getValue() == 0)
      {
        throw new IllegalExpressionException("Division by zero");
      }
      
      return new Constant(lhs.getValue() / rhs.getValue());
    } 
    else 
    {
      return new Division(lhs, rhs);
    }
  }
}
