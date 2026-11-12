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

  public int getPriority() {
    return 3;
  }

  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression expr = super.getExpr().eval(vars);

    if (expr.isConstant()) 
    {
      return new Constant(Math.exp(expr.getValue()));
    } 
    else 
    {
      return new Exp(expr);
    }
  }
}
