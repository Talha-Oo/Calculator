package org.ioopm.calculator.ast;

public class Negation extends Unary 
{
  public Negation(SymbolicExpression expr)
  {
    super(expr);
  }

  public String getName()
  {
    return "-";
  }

  public int getPriority() {
    return 3;
  }

  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression expr = super.getExpr().eval(vars);

    if (expr.isConstant()) 
    {
      return new Constant(-expr.getValue());
    } 
    else 
    {
      return new Negation(expr);
    }
  }
}
