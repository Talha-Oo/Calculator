package org.ioopm.calculator.ast;

public class NamedConstant extends Atom 
{
  private String identifier;
  private double value;

  /**
    * Creates a named constant with an identifier and value.
    * @param identifier the name of the constant
    * @param value the value of the constant
  */
  public NamedConstant(String identifier, double value) 
  {
    this.identifier = identifier;
    this.value = value;
  }

  /**
   * Indicates that this expression is a named constant.
   * @return true
   */
  public boolean isNamedConstant() {
    return true;
  }

  /**
   * Returns the operator priority of a named constant.
   * @return the priority value 4
   */
  public int getPriority() {
    return 4;
  }

  /**
   * Returns the value of this named constant.
   * @return the constant's value
  */
  public double getValue() {
    return value;
  }

  /**
   * Checks whether this named constant is equal to another object.
   * @param other the object to compare with
   * @return true if the object is a named constant with the same identifier and value, otherwise false
  */
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

  /**
   * Checks whether two named constants have the same identifier and value.
   * @param other the named constant to compare with
   * @return true if both named constants have the same identifier and value, otherwise false
  */
  public boolean equals(NamedConstant other) 
  {
    /// access a private field of other!
    return this.value == other.value && this.identifier.equals(other.identifier);
  }
  
  /**
   * Evaluates this named constant into a "normal" constant.
   * @param vars the environment used for evaluation
   * @return a Constant containing the value of this named constant
  */
  public SymbolicExpression eval(Environment vars) 
  {
    return new Constant(this.value);
  } 

  /**
   * Returns the identifier of this named constant.
   * @return the name of the named constant
  */
  public String toString() {
    return String.valueOf(this.identifier);
  }
}
