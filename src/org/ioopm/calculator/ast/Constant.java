package org.ioopm.calculator.ast;

public class Constant extends Atom {
  private double value;

  public Constant(double value) {
    this.value = value;
  }

  public boolean isConstant() {
    return true;
  }

  public int getPriority() {
    return 4;
  }

  public double getValue() {
    return value;
  }

  public String toString() {
    return String.valueOf(this.value);
  }
}
