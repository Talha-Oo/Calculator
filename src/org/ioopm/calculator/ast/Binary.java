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

  public SymbolicExpression getLhs()
  {
    return lhs;
  }

  public SymbolicExpression getRhs()
  {
    return rhs;
  }  

  private boolean lhsNeedParentheses()
  {
    return lhs.getPriority() < this.getPriority();
  }

  private String printLhs()
  {
    if(lhsNeedParentheses())
    {
      return "(" + lhs.toString() + ")";
    }

    return lhs.toString();
  }

  private boolean rhsNeedParentheses()
  {
    int prioRhs = rhs.getPriority();
    int prioParent = this.getPriority();
    String operator = this.getName();

    if (rhs.getPriority() < this.getPriority()) 
    {
      return true;
    }

    if (prioRhs == prioParent)
    {
      if (operator.equals("-"))
      {
        return true;
      }
      else if (operator.equals("/") && (rhs.getName().equals("*") || rhs.getName().equals("/")))
      {
        return true;
      }
    }

    return false;
  }

  private String printRhs()
  {
    if(rhsNeedParentheses())
    {
      return "(" + rhs.toString() + ")";
    }

    return rhs.toString();
  }

  public boolean equals(Object other) 
  {
    if (other instanceof Binary) 
    {
      return this.equals((Binary) other);
    } 
    else 
    {
      return false;
    }
  }

  public boolean equals(Binary other) 
  {
    if(this.getName().equals(other.getName()))
    {
      return this.rhs.equals(other.rhs) && this.lhs.equals(other.lhs);
    }

    return false;
  }

  public String toString() 
  {
    String operator = this.getName();
    return printLhs() + " " + operator + " " + printRhs();
  }
}
