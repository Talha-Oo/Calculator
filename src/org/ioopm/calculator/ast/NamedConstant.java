package org.ioopm.calculator.ast;

public class NamedConstant extends Atom 
{
  private String identifier;
  private double value;

  public NamedConstant(String identifier, double value) 
  {
    this.identifier = identifier;
    this.value = value;
  }

  public boolean isNamedConstant() {
    return true;
  }

  public int getPriority() {
    return 4;
  }

  public double getValue() {
    return value;
  }

  public boolean equals(Object other) 
  {
    if (other instanceof NamedConstant) 
    {
      return this.equals((NamedConstant) other);
    } 
    else 
    {
      return false;
    }
  }

  public boolean equals(NamedConstant other) 
  {
    /// access a private field of other!
    return this.value == other.value && this.identifier.equals(other.identifier);
  }
  
  public SymbolicExpression eval(Environment vars) 
  {
    return this;
  } 

  public String toString() {
    return String.valueOf(this.identifier);
  }
}
