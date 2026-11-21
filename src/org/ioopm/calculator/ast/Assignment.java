package org.ioopm.calculator.ast;

public class Assignment extends Binary 
{
  /**
   * Creates an assignment expression.
   * @param lhs the expression whose value will be assigned
   * @param rhs the variable that will receive the value
  */
  public Assignment(SymbolicExpression lhs, SymbolicExpression rhs)
  {
    super(lhs, rhs);
  }

  /**
   * Returns the assignment operator, "=".
   * @return the string "="
  */
  public String getName()
  {
    return "=";
  }

  /**
   * Evaluates the left-hand expression and assigns its value to the right-hand variable.
   * @param vars the environment in which the variable is stored
   * @return the evaluated left-hand expression
   * @throws IllegalAssignmentException if the assignment attempts to redefine a named constant
  */
  public SymbolicExpression eval(Environment vars) 
  {
    SymbolicExpression lhs = super.getLhs().eval(vars);
    SymbolicExpression rhs = super.getRhs();

    if(rhs.isNamedConstant())
    {
      throw new IllegalAssignmentException("Error: cannot redefine named constant '" + rhs.toString() + "'");
    }

    Variable var = (Variable) super.getRhs();

    vars.put(var, lhs);
    return lhs; 
  }
}
