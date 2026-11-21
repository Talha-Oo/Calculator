package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Environment extends HashMap<Variable, SymbolicExpression> {

  /**
   * Creates an empty environment for storing variable-value mappings.
  */
  public Environment()
  {
    super();
  }

  /**
   * Creates a copy of another environment.
   * @param other the environment to copy
  */
  public Environment(Environment other)
  {
    super(other);
  }
}
