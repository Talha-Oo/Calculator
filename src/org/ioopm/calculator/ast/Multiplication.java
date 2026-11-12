package org.ioopm.calculator.ast;

public class Multiplication extends Binary 
{
  
  public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  public String getName()
  {
    return "*";
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
      return new Constant(lhs.getValue() * rhs.getValue());
    } 
    else 
    {
      return new Multiplication(lhs, rhs);
    }
  }
}
