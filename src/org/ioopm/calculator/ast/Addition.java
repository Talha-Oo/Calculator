package org.ioopm.calculator.ast;

public class Addition extends Binary
{
  /**
   * Creates an addition expression with a left-hand and right-hand operands.
   * @param lhs the left-hand operand
   * @param rhs the right-hand operand
  */
  public Addition(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  /**
   * Returns the addition operator "+".
   * @return the string "+"
  */
  public String getName()
  {
    return "+";
  }

  /**
   * Returns the priority of the addition operator.
   *
   * @return the priority value 1
  */
  public int getPriority() {
    return 1;
  }

  /**
   * Evaluates both operands and adds them if both are constants.
   * Otherwise, returns a new addition expression with the evaluated operands.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated addition expression
  */
  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression lhs = super.getLhs().eval(vars);
    SymbolicExpression rhs = super.getRhs().eval(vars);

    if (lhs.isConstant() && rhs.isConstant()) 
    {
      return new Constant(lhs.getValue() + rhs.getValue());
    } 
    else 
    {
      return new Addition(lhs, rhs);
    }
  }
}
