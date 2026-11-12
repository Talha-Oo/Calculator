package org.ioopm.calculator.ast;
import java.util.HashMap;

public abstract class Atom extends SymbolicExpression {
  HashMap<Variable, SymbolicExpression> vars;
}
