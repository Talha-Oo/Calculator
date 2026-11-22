package org.ioopm.calculator;

import java.io.IOException;

import org.ioopm.calculator.ast.Environment;
import org.ioopm.calculator.ast.IllegalAssignmentException;
import org.ioopm.calculator.ast.Quit;
import org.ioopm.calculator.ast.Vars;
import org.ioopm.calculator.ast.Clear;
import org.ioopm.calculator.ast.Variable;
import org.ioopm.calculator.ast.SymbolicExpression;
import org.ioopm.calculator.parser.CalculatorParser;
import org.ioopm.calculator.parser.IllegalExpressionException;
import org.ioopm.calculator.parser.SyntaxErrorException;

public class Calculator {
  public static void main(String[] args) throws IOException {

    // skapa tom enviroment och parser
    final CalculatorParser parser = new CalculatorParser();
    final Environment store = new Environment();

    int expressionsEntered = 0;
    int successfullyEvaluated = 0;
    int fullyEvaluated = 0;

    while (true) {
      // läser från stdin
      System.out.print("Please enter an Expresison: ");
      String input = System.console().readLine();
      
      // skicka till parser och hantera varje case
      SymbolicExpression result;
      try {
        result = parser.parse(input, store);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
      }

      if (result.isCommand()) {
        if (result == Quit.instance()) {
          System.out.println("Goodbye!");
          System.out.println("Expressions entered: " + expressionsEntered);
          System.out.println("Successfully evaluated: " + successfullyEvaluated);
          System.out.println("Fully evaluated: " + fullyEvaluated);
          break;
        } else if (result == Clear.instance()) {
          store.clear();
        } else if (result == Vars.instance()) {
          String list = store.toString();
          System.out.println("(" + list + ")");
        }
      } else {

        expressionsEntered++;
        Environment backup = new Environment(store);
        try {
          SymbolicExpression ans = result.eval(store);
          Variable v = new Variable("ans");

          store.put(v, ans);
          if (ans.isConstant()) {
            fullyEvaluated++;
          }

          System.out.println("(" + ans + ")");
          successfullyEvaluated++;

        } catch (SyntaxErrorException e) {

          System.out.println("Invalid syntax, try again");
          store.clear();
          store.putAll(backup);

        } catch (IllegalExpressionException e) {

          System.out.println("Illegal expression, try again");
          store.clear();
          store.putAll(backup);

        } catch (IllegalAssignmentException e) {

          System.out.println(e.getMessage());
          store.clear();
          store.putAll(backup);

        }
      }
    }
  }
}