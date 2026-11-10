package org.ioopm.calculator.ast;

public class Exp extends Unary 
{
  public Exp(SymbolicExpression expr) 
  {
    super(expr);
  }

  public String getName()
  {
    return "exp";
  }
}
