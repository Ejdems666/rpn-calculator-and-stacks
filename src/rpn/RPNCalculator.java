package rpn;

import rpn.operations.Operation;
import utility.Stack;

import java.util.Iterator;
import java.util.List;

public class RPNCalculator {
    public Stack<Integer> calculate(Stack<Integer> numbersStack, List<Operation> operations) {
        if (!operations.isEmpty()) {
            try {
                numbersStack = calculateOperations(numbersStack, operations);
            } catch (NotEnoughNumbersException e) {
                System.out.println(e.getMessage());
                operations.remove(operations.size() - 1); // Cleanup operations
            }
        }
        return numbersStack;
    }

    private Stack<Integer> calculateOperations(Stack<Integer> numbersStack, List<Operation> operations) throws NotEnoughNumbersException {
        Iterator<Operation> iterator = operations.iterator();
        while (iterator.hasNext()) {
            if (numbersStack.size() <= 1) {
                throw new NotEnoughNumbersException("Not enough number on the stack!");
            }
            Integer number2 = numbersStack.pop();
            Integer number1 = numbersStack.pop();
            Operation operation = iterator.next();
            numbersStack.push(operation.evaluate(number2, number1));
            iterator.remove();
        }
        return numbersStack;
    }
}
