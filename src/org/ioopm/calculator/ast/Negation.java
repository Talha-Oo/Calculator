package org.ioopm.calculator.ast;

public class Negation extends Unary 
{
  /**
   * Creates a negation expression.
   * @param expr the expression to be negated
  */
  public Negation(SymbolicExpression expr)
  {
    super(expr);
  }

  /**
   * Returns the negation operator, "-".
   * @return the string "-"
  */
  public String getName()
  {
    return "-";
  }

  /**
   * Returns the operator priority of negation.
   * @return the priority value 3
  */
  public int getPriority() {
    return 3;
  }

  /**
   * Evaluates the negation if its operand is a constant. Otherwise, returns a new negation 
   * expression with the evaluated operand.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated negation expression
  */
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
