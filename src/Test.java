import org.ioopm.calculator.ast.*;

public class Test {

  public void testPrinting(String expected, SymbolicExpression e) {

    // assert expected.equals("" + e) : "Error: expected '" + expected + "' but got '" + e + "'";
    // System.out.println("Passed: " + e);
    
    if (expected.equals("" + e)) {
      System.out.println("Passed: " + e);
    } else {
      System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
    }
  }

  public static void main(String[] args) {

    Test test = new Test();
    Constant c1 = new Constant(5);
    Constant c2 = new Constant(2);
    Variable v = new Variable("x");
    Addition a = new Addition(c1, v);
    Multiplication m = new Multiplication(a, c2);

    test.testPrinting("(5 + x) * 2", m);

    Constant c = new Constant(42);
    test.testPrinting("42", c);

    Division d = new Division(new Constant(20), new Constant(5));
    test.testPrinting("20 / 5", d);

    Subtraction s = new Subtraction(new Constant(10), new Constant(4));
    test.testPrinting("10 - 4", s);

    Sin sin = new Sin(new Constant(90));
    test.testPrinting("sin(90)", sin);

    Negation n = new Negation(new Constant(5));
    test.testPrinting("-5", n);
  }
}