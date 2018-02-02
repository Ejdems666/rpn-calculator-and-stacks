package rpn;

import rpn.parser.Parser;
import rpn.parser.ParserException;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        RPNCalculator calculator = new RPNCalculator();
        CalculatorIOController controller = new CalculatorIOController(calculator, parser, scanner);
        controller.start();
    }
}
