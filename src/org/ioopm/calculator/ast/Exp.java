package org.ioopm.calculator.ast;


public class Exp extends Unary 
{
  /**
   * Creates an exponential expression.
   * @param expr the expression to which the exponential function is applied
  */
  public Exp(SymbolicExpression expr) 
  {
    super(expr);
  }

  /**
   * Returns the name of the exponential function, "exp".
   * @return the string "exp"
   */
  public String getName()
  {
    return "exp";
  }

  /**
   * Returns the operator priority of the exponential function.
   * @return the priority value 3
  */
  public int getPriority() {
    return 3;
  }

  /**
   * Evaluates the exponential expression if its operand is a constant. Otherwise, returns a new 
   * exponential expression with the evaluated operand.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated exponential expression
  */
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
