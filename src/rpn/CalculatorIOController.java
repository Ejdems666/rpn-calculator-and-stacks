package rpn;

import rpn.exceptions.NotEnoughNumbersException;
import rpn.operations.*;
import rpn.exceptions.OperationParsingException;
import utility.PathStack;
import utility.Stack;

import java.util.Scanner;

public class CalculatorIOController {
    private RPNCalculator calculator;
    private Scanner scanner;

    public CalculatorIOController(RPNCalculator calculator, Scanner scanner) {
        this.calculator = calculator;
        this.scanner = scanner;
    }

    public void start() {
        Stack<Integer> numbersStack = new PathStack<>();
        while (true) {
            String consoleInput = scanner.nextLine();
            if (consoleInput.equals("END")) {
                break;
            }
            String[] rawArguments = consoleInput.split(" ");
            Operation operation;
            try {
                for (String rawArgument : rawArguments) {
                    try {
                        numbersStack.push(Integer.parseInt(rawArgument));
                    } catch (NumberFormatException e) {
                        switch (rawArgument) {
                            case "*":
                                operation = new Multiplication();
                                break;
                            case "/":
                                operation = new Divison();
                                break;
                            case "+":
                                operation = new Addition();
                                break;
                            case "-":
                                operation = new Substitution();
                                break;
                            default:
                                throw new OperationParsingException("Unknown operation!");
                        }
                        numbersStack = calculator.calculate(numbersStack, operation);
                    }
                }
            } catch (NotEnoughNumbersException | OperationParsingException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(numbersStack);
        }
    }
}
