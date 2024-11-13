import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GenerateTruthTable gtt = new GenerateTruthTable();
        Scanner scanner = new Scanner(System.in);

       System.out.println("Type the boolean expression to create a truth table (do not use spaces)");
        String booleanExpression = scanner.next();


        InfixToPostfix ip = new InfixToPostfix();

        ip.setBooleanExpression(booleanExpression);
        ip.setLength(booleanExpression.length());

        System.out.println(ip.getBooleanExpression());
        String postfix = ip.convertToPostfix();
        System.out.println(postfix);
        gtt.setExpression(postfix);

    }
}