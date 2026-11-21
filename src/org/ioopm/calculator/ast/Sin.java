package org.ioopm.calculator.ast;

public class Sin extends Unary  {
  
  /**
   * Creates a sine expression.
   * @param expr the expression to which the sine function is applied
  */
  public Sin(SymbolicExpression expr)
  {
    super(expr);
  }

  /**
   * Returns the name of the sine function, "sin".
   * @return the string "sin"
  */
  public String getName()
  {
    return "sin";
  }

  /**
   * Returns the operator priority of the sine function.
   * @return the priority value 3
  */
  public int getPriority() {
    return 3;
  }

  /**
   * Evaluates the sine expression if its operand is a constant. Otherwise, returns a new sine 
   * expression with the evaluated operand.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated sine expression
  */
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

