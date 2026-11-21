package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Environment extends HashMap<Variable, SymbolicExpression> {

  public Environment()
  {
    super();
  }

  public Environment(Environment other)
  {
    super(other);
  }
}
