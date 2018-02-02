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
            } catch (Exception e) {
                operations.remove(operations.size() - 1);
            }
        }
        return numbersStack;
    }

    private Stack<Integer> calculateOperations(Stack<Integer> numbersStack, List<Operation> operations) throws Exception {
        Iterator<Operation> iterator = operations.iterator();
        while (iterator.hasNext()) {
            if (numbersStack.size() <= 1) {
                throw new Exception("No more numberes hombre, fuck sake");
            }
            Integer number1 = numbersStack.pop();
            Integer number2 = numbersStack.pop();
            Operation operation = iterator.next();
            numbersStack.push(operation.evaluate(number2, number1));
            iterator.remove();
        }
        return numbersStack;
    }
}
