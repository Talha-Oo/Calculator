package org.ioopm.calculator.ast;
public class Variable extends Atom 
{
  private String identifier;

  /**
   * Creates a variable with the specified identifier.
   * @param identifier the name of the variable
  */
  public Variable(String identifier)
  {
    this.identifier = identifier;
  }

  /**
   * Returns the operator precedence of a variable.
   * @return the priority value 4
  */
  public int getPriority() {
    return 4;
  }

  /**
   * Checks whether this variable is equal to another object.
   * @param other the object to compare with
   * @return true if the object is a variable with the same identifier, otherwise false
  */
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

  /**
   * Checks whether two variables have the same identifier.
   * @param other the variable to compare with
   * @return true if both variables have the same identifier, otherwise false
  */
  public boolean equals(Variable other) 
  {
    return this.identifier.equals(other.identifier);
  }

  /**
   * Returns the identifier of this variable.
   * @return the variable's identifier
  */
  public String toString()
  {
    return identifier;
  }

  /**
   * Evaluates this variable using the supplied environment. If the variable has a stored value, 
   * that value is returned. Otherwise, this variable is returned unchanged.
   * @param vars the environment containing variable values
   * @return the stored value or this variable if no value is found
   */
  public SymbolicExpression eval(Environment vars)
  {
    SymbolicExpression value = vars.get(this);
    if(value != null)
    {
      return value;
    }
    
    return this;
  }

  /**
   * Returns the hash code of this variable based on its identifier.
   * @return the hash code of the identifier
  */
  public int hashCode()
  {
    return identifier.hashCode();
  }
}
