package org.ioopm.calculator.ast;

public class Subtraction extends Binary 
{
  /**
   * Creates a subtraction expression with a left-hand and right-hand operand.
   * @param lhs the left-hand operand
   * @param rhs the right-hand operand
  */
  public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  /**
   * Returns the subtraction operator, "-".
   * @return the string "-"
   */
  public String getName()
  {
    return "-";
  }

  /**
   * Returns the operator priority of subtraction.
   * @return the priority value 1
  */
  public int getPriority() {
    return 1;
  }

  /**
   * Evaluates the subtraction if both operands are constants. Otherwise, returns a new 
   * subtraction expression with the evaluated operands.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated subtraction expression
  */
  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression lhs = super.getLhs().eval(vars);
    SymbolicExpression rhs = super.getRhs().eval(vars);

    if (lhs.isConstant() && rhs.isConstant()) 
    {
      return new Constant(lhs.getValue() - rhs.getValue());
    } 
    else 
    {
      return new Subtraction(lhs, rhs);
    }
  }
}
