package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression 
{
  private SymbolicExpression lhs;
  private SymbolicExpression rhs;

  public Binary(SymbolicExpression lhs, SymbolicExpression rhs) 
  {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  public String toString() 
  {
    int prioLhs = lhs.getPriority();
    int prioRhs = rhs.getPriority();
    int prioParent = this.getPriority();

    String operator = this.getName();

    if (prioLhs < prioParent) 
    {
      if (prioRhs < prioParent) 
      {
        return "(" + lhs.toString() + ")" + " " + operator + " " + "(" + rhs.toString() + ")";
      }

      return "(" + lhs.toString() + ")" + " " + operator + " " + rhs.toString();

    } 
    else if (prioRhs < prioParent) 
    {
      return lhs.toString() + " " + operator + " " + "(" + rhs.toString() + ")";
    } 
    else
    {
      if (prioRhs == prioParent)
      {
        if (operator.equals("-"))
        {
          return lhs.toString() + " " + operator + " " + "(" + rhs.toString() + ")";
        }
        else if (operator.equals("/") && (rhs.getName().equals("*") || rhs.getName().equals("/")))
        {
          return lhs.toString() + " " + operator + " " + "(" + rhs.toString() + ")";
        }
      }
      return lhs.toString() + " " + operator + " " + rhs.toString();
    }
  }
}
