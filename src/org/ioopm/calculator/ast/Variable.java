package org.ioopm.calculator.ast;

public class Variable extends Atom {
  private String identifier;

  public Variable(String identifier)
  {
    this.identifier = identifier;
  }

  public int getPriority() {
    return 4;
  }

  public String toString()
  {
    return identifier;
  }
}
