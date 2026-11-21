package org.ioopm.calculator.ast;

public class Cos extends Unary {
  
  /**
   * Creates a cosine expression.
   * @param expr the expression to which the cosine function is applied
  */
  public Cos(SymbolicExpression expr)
  {
    super(expr);
  }

  /**
   * Returns the name of the cosine function, "cos".
   * @return the string "cos"
  */
  public String getName()
  {
    return "cos";
  }

  /**
   * Returns the operator priority of the cosine function.
   * @return the priority value 3
  */
  public int getPriority() {
    return 3;
  }

  /**
   * Evaluates the cosine expression if its operand is a constant. Otherwise, returns a new 
   * cosine expression with the evaluated operand.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated cosine expression
  */
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
