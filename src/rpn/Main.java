package rpn;

import rpn.parser.Parser;
import rpn.parser.ParserException;
import rpn.operations.Operation;
import utility.ArrayStack;
import utility.Stack;

import java.util.*;


public class Main {
    public static void main(String[] args) throws ParserException {
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        RPNCalculator calculator = new RPNCalculator();
        Stack<Integer> numbersStack = new ArrayStack<>();
        List<Operation> operations = new ArrayList<>();
        while (true) {
            String consoleInput = in.nextLine();
            if (consoleInput.equals("END")) {
                break;
            }
            String[] rawArguments = consoleInput.split(" ");
            int oldSize = numbersStack.size();
            numbersStack = parser.parseNumbers(numbersStack, rawArguments);
            int countOfAddedNumbers = numbersStack.size() - oldSize;
            operations = parser.parseOperations(operations, countOfAddedNumbers, rawArguments);
            numbersStack = calculator.calculate(numbersStack,operations);
            System.out.println(numbersStack);
        }
    }


}
