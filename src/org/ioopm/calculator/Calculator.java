// package org.ioopm.calculator;

// import java.io.IOException;

// import org.ioopm.calculator.ast.Environment;
// import org.ioopm.calculator.ast.Quit;
// import org.ioopm.calculator.ast.SymbolicExpression;
// import org.ioopm.calculator.ast.Vars;
// import org.ioopm.calculator.parser.CalculatorParser;

// public class Calculator {
//     public static void main(String[] args) throws IOException {
    
//     //skapa tom enviroment och parser
//     final CalculatorParser parser = new CalculatorParser();
//     final Environment store = new Environment();

//     while (true) {
//         //läser från stdin
//         String input = System.console().readLine();
//         //skicka till parser och hantera varje case
//         SymbolicExpression result = parser.parse(input, store);
//         if (result.isCommand()) {
//             if (result == Quit.instance()) {
//                 break;
//             } else if (result == Vars.instance()) {
//                 store.values();
//             //  } else if (result == Clear.instance())) Vars v {
//             //         store.clear();
//             //     }
//               }
//         } else {
//             SymbolicExpression ans = result.eval(store);
//             ans.getValue();
//             System.out.println("+ ans +");
//     }
//     }

// }
// }