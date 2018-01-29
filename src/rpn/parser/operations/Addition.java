package rpn.parser.operations;

public class Addition implements Operation {
    @Override
    public Integer evaluate(Integer element1, Integer element2) {
        return element1 + element2;
    }
}
