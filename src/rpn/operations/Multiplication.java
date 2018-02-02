package rpn.operations;

public class Multiplication implements Operation {
    @Override
    public Integer evaluate(Integer number1, Integer number2) {
        return number1 * number2;
    }
}
