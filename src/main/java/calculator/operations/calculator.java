package calculator.operations;

import java.util.Scanner;

public class calculator {
    private static double prevResult = 0;

    /* main method is the entry point of the program.
    It prompts the user to enter an expression and uses the evaluate method to evaluate it.
    If the user enters "q", the program will exit.
    The program also has a prevResult variable that keeps track of the previous result, 
    which can be used as an operand in the next expression. 
    If the user enters an expression that starts with an operator, 
    it is assumed that the user wants to use the previous result as the first operand and 
    the input string is modified accordingly before being passed to the evaluate method
    */ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter expression (or 'q' to exit): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("You have exited the calculator.\nBye.");
                break;
            }
            if (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/') {
                input = prevResult + input;
            }
            prevResult = helper.evaluate(input);
            System.out.println("Result: " + prevResult);
        }
        sc.close();
    }
}