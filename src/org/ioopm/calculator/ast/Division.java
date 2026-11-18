package org.ioopm.calculator.ast;

import org.ioopm.calculator.parser.IllegalExpressionException;

public class Division extends Binary 
{
  public Division(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  public String getName()
  {
    return "/";
  }

  public int getPriority() {
    return 2;
  }

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
