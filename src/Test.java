import org.ioopm.calculator.ast.*;

public class Test {

  public static void main(String[] args) {
    Constant c1 = new Constant(5);
    Constant c2 = new Constant(2);
    Variable v = new Variable("x");
    Addition a = new Addition(c1, v);
    Multiplication m = new Multiplication(a, c2);

    System.out.println("(5 + x) * 2 ==> " + m);

    Constant c = new Constant(42);
    System.out.println("42 ==> " + c);

    Division d = new Division(new Constant(20), new Constant(5));
    System.out.println("20 / 5 ==> " + d);

    Subtraction s = new Subtraction(new Constant(10), new Constant(4));
    System.out.println("10 - 4 ==> " + s);

    Sin sin = new Sin(new Constant(90));
    System.out.println("sin(90) ==> " + sin);

    Negation n = new Negation(new Constant(5));
    System.out.println("-5 ==> " + n);
  }
}