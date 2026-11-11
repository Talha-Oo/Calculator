import org.ioopm.calculator.ast.*;

public class Test {

  public void testPrinting(String expected, SymbolicExpression e) {

    assert expected.equals("" + e) : "Error: expected '" + expected + "' but got '" + e + "'";
    System.out.println("Passed: " + e);
    
    // if (expected.equals("" + e)) {
    //   System.out.println("Passed: " + e);
    // } else {
    //   System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
    // }
  }

  public static void main(String[] args) {

    Test test = new Test();
    Constant c1 = new Constant(5);
    Constant c2 = new Constant(2);
    Variable v = new Variable("x");
    Addition a = new Addition(c1, v);
    Multiplication m = new Multiplication(a, c2);
    test.testPrinting("(5.0 + x) * 2.0", m);

    Constant c = new Constant(42);
    test.testPrinting("42.0", c);

    Division d = new Division(new Constant(20), new Constant(5));
    test.testPrinting("20.0 / 5.0", d);

    Subtraction s = new Subtraction(new Constant(10), new Constant(4));
    test.testPrinting("10.0 - 4.0", s);

    Sin sin = new Sin(new Constant(90));
    test.testPrinting("sin(90.0)", sin);

    Negation n = new Negation(new Constant(5));
    test.testPrinting("-(5.0)", n);

    Variable z = new Variable("z");
    Constant c3 = new Constant(3);
    Addition a1 = new Addition(z, c3);
    Sin sin2 = new Sin(a1);
    test.testPrinting("sin(z + 3.0)", sin2);

    Variable p = new Variable("p");
    Variable q = new Variable("q");
    Variable r = new Variable("r");
    Addition a2 = new Addition(p, q);
    Subtraction s2 = new Subtraction(r, new Constant(4));
    Multiplication m2 = new Multiplication(a2, s2);
    Division d2 = new Division(m2, new Constant(2));
    test.testPrinting("(p + q) * (r - 4.0) / 2.0", d2);
  }
}