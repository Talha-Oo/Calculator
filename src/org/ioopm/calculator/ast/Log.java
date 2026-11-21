package org.ioopm.calculator.ast;

public class Log extends Unary 
{
  /**
   * Creates a logarithm expression.
   * @param expr the expression to which the natural logarithm is applied
  */
  public Log(SymbolicExpression expr) {
    super(expr);
  }

  /**
   * Returns the name of the logarithm function, "log".
   * @return the string "log"
   */
  public String getName()
  {
    return "log";
  }

  /**
   * Returns the operator priority of the logarithm function.
   * @return the priority value 3
  */
  public int getPriority() {
    return 3;
  }

  /**
   * Evaluates the logarithm expression if its operand is a constant. Otherwise, returns a new 
   * logarithm expression with the evaluated operand.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated logarithm expression
  */
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
