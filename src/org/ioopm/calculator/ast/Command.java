package org.ioopm.calculator.ast;

public abstract class Command extends SymbolicExpression 
{
  /**
   * Prevents commands from being evaluated as ordinary expressions.
   * @param vars the environment used for evaluation
   * @throws RuntimeException because commands should not be evaluated
  */
  public SymbolicExpression eval(Environment vars)
  {
    throw new RuntimeException("Commands shall not be evaluated.");
  }
  
  /**
   * Indicates that this expression represents a command.
   * @return true
  */
  public boolean isCommand()
  {
    return true;
  }
}
