package org.ioopm.calculator.ast;

public class Constant extends Atom {
  private double value;

  /**
   * Creates a constant with the specified value.
   * @param value the value of the constant
  */
  public Constant(double value) {
    this.value = value;
  }

  /**
   * Indicates that this expression is a constant.
   * @return true
  */
  public boolean isConstant() {
    return true;
  }

  /**
   * Returns the operator priority of a constant.
   * @return the priority value 4
  */
  public int getPriority() {
    return 4;
  }

  /**
   * Returns the value of this constant.
   * @return the constant's value
  */
  public double getValue() {
    return value;
  }

  /**
   * Checks whether this constant is equal to another object.
   * @param other the object to compare with
   * @return true if the object is a constant with the same value, otherwise false
  */
  public boolean equals(Object other) 
  {
    if (other instanceof Constant) 
    {
      return this.equals((Constant) other);
    } 
    else 
    {
      return false;
    }
  }

  /**
   * Checks whether two constants have the same value.
   * @param other the constant to compare with
   * @return true if both constants have the same value, otherwise false
  */
  public boolean equals(Constant other) 
  {
    /// access a private field of other!
    return this.value == other.value;
  }
  
  // public SymbolicExpression eval(Environment vars) 
  // {
  //   return this;
  // } 

  /**
   * Evaluates this constant.
   * @param vars the environment used for evaluation
   * @return this constant
  */
  @Override 
  public Constant eval(Environment vars) 
  {
    return this;
  } 

  /**
   * Returns the value as a string.
   * @return the string representation of this constant
  */
  public String toString() {
    return String.valueOf(this.value);
  }
}

