package rpn;

import rpn.parser.Parser;
import rpn.parser.ParserException;
import rpn.parser.operations.Operation;
import utility.ArrayStack;
import utility.PathStack;
import utility.Stack;

import java.util.*;


public class Main {
    public static void main(String[] args) throws ParserException {
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
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
            if (!operations.isEmpty()) {
                try {
                    calculate(numbersStack, operations);
                } catch (Exception e) {
                    operations.remove(operations.size()-1);
                }
            }
            System.out.println(numbersStack);
        }
    }

    private static void calculate(Stack<Integer> numbersStack, List<Operation> operations) throws Exception {
        Iterator<Operation> iterator = operations.iterator();
        while (iterator.hasNext()) {
            if (numbersStack.size() <= 1) {
                throw new Exception("No more numberes hombre, fuck sake");
            }
            Integer number1 = numbersStack.pop();
            Integer number2 = numbersStack.pop();
            Operation operation = iterator.next();
            numbersStack.push(operation.evaluate(number2,number1));
            iterator.remove();
        }
    }
}
