package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
  private SymbolicExpression expr;

  public Unary(SymbolicExpression expr) {
    this.expr = expr;
  }

  public boolean equals(Object other) 
  {
    if (other instanceof Unary) 
    {
      return this.equals((Unary) other);
    } 
    else 
    {
      return false;
    }
  }

  public boolean equals(Unary other) 
  {
    if(this.getName().equals(other.getName()))
    {
      return this.expr.equals(other.expr);
    }

    return false;
  }
  
  public SymbolicExpression getExpr()
  {
    return expr;
  }

  public String toString() {
    return this.getName() + "(" + this.expr.toString() + ")";
  }
}
