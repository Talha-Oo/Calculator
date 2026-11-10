package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
  private SymbolicExpression expr;

  public Unary(SymbolicExpression expr)
  {
    this.expr = expr;
  }
}
