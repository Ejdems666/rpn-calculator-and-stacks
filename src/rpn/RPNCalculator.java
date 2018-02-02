package rpn;

import rpn.exceptions.NotEnoughNumbersException;
import rpn.operations.Operation;
import utility.Stack;

public class RPNCalculator {
    public Stack<Integer> calculate(Stack<Integer> numbersStack, Operation operation) throws NotEnoughNumbersException {
        if (numbersStack.size() <= 1) {
            throw new NotEnoughNumbersException("Not enough number on the stack!");
        }
        Integer number2 = numbersStack.pop();
        Integer number1 = numbersStack.pop();
        Integer result = operation.evaluate(number2, number1);
        numbersStack.push(result);
        return numbersStack;
    }
}
