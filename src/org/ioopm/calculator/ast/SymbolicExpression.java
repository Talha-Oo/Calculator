package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {
  
  public boolean isConstant()
  {
    return false;
  }

  public String getName()
  {
    throw new RuntimeException("getName() called on expression with no operator");
  }

  public int getPriority()
  {
    return 0;
  }

  public double getValue()
  {
    throw new RuntimeException("getvalue() called on expression which is not a constant");
  }

  public abstract SymbolicExpression eval(Environment vars);

  public boolean isCommand()
  {
    return false;
  }

  public boolean isNamedConstant()
  {
    return false;
  }
}
