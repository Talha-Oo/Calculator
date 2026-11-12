package org.ioopm.calculator.ast;

public class Cos extends Unary {
  
  public Cos(SymbolicExpression expr)
  {
    super(expr);
  }

  public String getName()
  {
    return "cos";
  }

  public int getPriority() {
    return 3;
  }

  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression expr = super.getExpr().eval(vars);

    if (expr.isConstant()) 
    {
      return new Constant(Math.cos(expr.getValue()));
    } 
    else 
    {
      return new Cos(expr);
    }
  }
}
