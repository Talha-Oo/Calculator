package org.ioopm.calculator.ast;

public class Multiplication extends Binary 
{
  /**
   * Creates a multiplication expression with a left-hand and right-hand operand.
   * @param lhs the left-hand operand
   * @param rhs the right-hand operand
  */
  public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  /**
   * Returns the multiplication operator, "*".
   * @return the string "*"
  */
  public String getName()
  {
    return "*";
  }

  /**
   * Returns the operator priority of multiplication.
   * @return the priority value 2
  */
  public int getPriority() {
    return 2;
  }

  /**
   * Evaluates the multiplication if both operands are constants. Otherwise, returns a new 
   * multiplication expression with the evaluated operands.
   * @param vars the environment containing variable values
   * @return the resulting constant or unevaluated multiplication expression
  */
  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression lhs = super.getLhs().eval(vars);
    SymbolicExpression rhs = super.getRhs().eval(vars);

    if (lhs.isConstant() && rhs.isConstant()) 
    {
      return new Constant(lhs.getValue() * rhs.getValue());
    } 
    else 
    {
      return new Multiplication(lhs, rhs);
    }
  }
}
