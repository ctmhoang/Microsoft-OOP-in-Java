import java.util.Scanner;

public class FractionCalculatorAdvanced {
    public static void main(String[] args) {
        Scanner INPUT = new Scanner(System.in);
        System.out.println("This program is a fraction calculator /n" +
                "It will add, subtract, multiply and divide fractions until you type Q to quit. \n" +
                "Valid operations are of the form \" [FRAC] [OPERATION] [FRAC] \" \n" +
                "[FRAC] can be either a single integer or two integers seperated by \"/\" . \n" +
                "[OPERATION] can be +, - , *, / or = . \n");
        while (true) {
            Main.seperator();
            System.out.println("Enter an operation (q to quit): ");
            String opers = INPUT.nextLine();
            while (!checkExpression(opers)){
                System.out.println("Invalid operation must be \" [FRAC] [OPERATION] [FRAC] \" ");
                opers = INPUT.nextLine();
            }
            if(opers.equalsIgnoreCase("q")){
                break;
            }
            String[] operParts = opers.split("\\s+");
            String f1 = operParts[0], oper = operParts[1], f2 = operParts[2];
            if (!(Main.validFraction(f1) && Main.validFraction(f2))) {
                System.out.println("Invalid fraction. a and b are integers and b is not a zero and chars ");
                continue;
            }
            Fraction F1 = getFraction(f1);
            Fraction F2 = getFraction(f2);
            if (oper.equals("+")) {
                Fraction fres = F1.add(F2);
                fres.toLowestTerms();
                System.out.println(f1.toString() + " + " + f2.toString() + " = " + fres.toString());
            }
            if (oper.equals("-")) {
                Fraction fres = F1.subtract(F2);
                fres.toLowestTerms();
                System.out.println(f1.toString() + " - " + f2.toString() + " = " + fres.toString());
            }
            if (oper.equals("*")) {
                Fraction fres = F1.multiply(F2);
                fres.toLowestTerms();
                System.out.println(F1.toString() + " * " + F2.toString() + " = " + fres.toString());
            }
            if (oper.equals("/")) {
                Fraction fres = F1.divide(F2);
                fres.toLowestTerms();
                System.out.println(F1.toString() + " / " + F2.toString() + " = " + fres.toString());
            }
            if (oper.equals("=")) {
                System.out.println(F1.toString() + " = " + F2.toString() + " is " + F1.equals(f2));
            }
        }
    }

    public static boolean checkExpression(String input) {
        String[] choices = {"+", "-", "/", "*", "="}, express = input.split("\\s+");
        if(express.length == 1){
            return express[0].equalsIgnoreCase("q");
        }
        return express.length <= 3 && (Main.isOperator(express[1], choices)
                || Main.validFraction(express[0]) || Main.validFraction(express[2]));
    }
    public static Fraction getFraction(String fraction) {
        if (fraction.contains("/") && fraction.indexOf("/") < fraction.length() - 1) {
            int num = Integer.parseInt(fraction.substring(0, fraction.indexOf("/"))),
            denom = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
            return new Fraction(num, denom);
        }
        return new Fraction(Integer.parseInt(fraction));
    }
}
