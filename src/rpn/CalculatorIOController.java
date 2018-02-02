package rpn;

import rpn.operations.Operation;
import rpn.parser.Parser;
import rpn.parser.ParserException;
import utility.ArrayStack;
import utility.PathStack;
import utility.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorIOController {
    private RPNCalculator calculator;
    private Parser parser;
    private Scanner scanner;

    public CalculatorIOController(RPNCalculator calculator, Parser parser, Scanner scanner) {
        this.calculator = calculator;
        this.parser = parser;
        this.scanner = scanner;
    }

    public void start() throws ParserException {
        Stack<Integer> numbersStack = new ArrayStack<>();
        List<Operation> operations = new ArrayList<>();
        while (true) {
            String consoleInput = scanner.nextLine();
            if (consoleInput.equals("END")) {
                break;
            }
            String[] rawArguments = consoleInput.split(" ");
            int oldSize = numbersStack.size();
            numbersStack = parser.parseNumbers(numbersStack, rawArguments);
            int countOfAddedNumbers = numbersStack.size() - oldSize;
            operations = parser.parseOperations(operations, countOfAddedNumbers, rawArguments);
            numbersStack = calculator.calculate(numbersStack, operations);
            System.out.println(numbersStack);
        }
    }
}
