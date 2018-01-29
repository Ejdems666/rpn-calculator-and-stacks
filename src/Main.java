import utility.PathStack;

public class Main {
    public static void main(String[] args) {
        PathStack<Integer> stack = new PathStack<>();
        stack.push(7);
        stack.push(9);
        stack.push(13);
        System.out.println(stack.pop());
        stack.push(15);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
