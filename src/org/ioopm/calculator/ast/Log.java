package org.ioopm.calculator.ast;

public class Log extends Unary 
{
  public Log(SymbolicExpression expr) {
    super(expr);
  }

  public String getName()
  {
    return "log";
  }

  public int getPriority() {
    return 3;
  }

  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression expr = super.getExpr().eval(vars);

    if (expr.isConstant()) 
    {
      return new Constant(Math.log(expr.getValue()));
    } 
    else 
    {
      return new Log(expr);
    }
  }
}
