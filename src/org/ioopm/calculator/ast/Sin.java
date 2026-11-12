package org.ioopm.calculator.ast;

public class Sin extends Unary  {
  
  public Sin(SymbolicExpression expr)
  {
    super(expr);
  }

  public String getName()
  {
    return "sin";
  }

  public int getPriority() {
    return 3;
  }

  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression expr = super.getExpr().eval(vars);

    if (expr.isConstant()) 
    {
      return new Constant(Math.sin(expr.getValue()));
    } 
    else 
    {
      return new Sin(expr);
    }
  }
}

