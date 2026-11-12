package org.ioopm.calculator.ast;
public class Variable extends Atom 
{
  private String identifier;

  public Variable(String identifier)
  {
    this.identifier = identifier;
  }

  public int getPriority() {
    return 4;
  }

  public boolean equals(Object other) 
  {
    if (other instanceof Variable) 
    {
      return this.equals((Variable) other);
    } 
    else 
    {
      return false;
    }
  }

  public boolean equals(Variable other) 
  {
    return this.identifier.equals(other.identifier);
  }

  public String toString()
  {
    return identifier;
  }

  public SymbolicExpression eval(Environment vars)
  {
    SymbolicExpression value = vars.get(this);
    if(value != null)
    {
      return value;
    }
    
    return this;
  }

  public int hashCode()
  {
    return identifier.hashCode();
  }
}
