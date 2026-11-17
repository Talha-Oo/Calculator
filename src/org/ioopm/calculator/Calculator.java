package org.ioopm.calculator;

import java.io.IOException;

import org.ioopm.calculator.ast.Environment;
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
    
    //skapa tom enviroment och parser
    final CalculatorParser parser = new CalculatorParser();
    final Environment store = new Environment();

    while (true) {
        //läser från stdin
        System.out.println("Please enter an Expresison");
        String input = System.console().readLine();
        //skicka till parser och hantera varje case
        SymbolicExpression result = parser.parse(input, store);
        if (result.isCommand()) {
            if (result == Quit.instance()) {
                break;
            } else if (result == Clear.instance()) {
                store.clear();
                } else if (result == Vars.instance()) {
                    String list = store.toString();
                    System.out.println("(" + list + ")");
                }
} else {
    try {
        SymbolicExpression ans = result.eval(store);
        Variable v = new Variable("ans");
        store.put(v, ans);
        System.out.println("(" + ans + ")");

    } catch (SyntaxErrorException e) {
        System.out.println("Invalid syntax, try again");

    } catch (IllegalExpressionException e) {
        System.out.println("Illegal expression, try again");
    }
}
}
}
}