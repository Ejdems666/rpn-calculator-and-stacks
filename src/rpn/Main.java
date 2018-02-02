package rpn;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RPNCalculator calculator = new RPNCalculator();
        CalculatorIOController controller = new CalculatorIOController(calculator, scanner);
        controller.start();
    }
}
