import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner INPUT = new Scanner(System.in);
        System.out.println("This program is a fraction calculator /n" +
                "It will add, subtract, multiply and divide fractions until you type Q to quit. \n");
        while (true) {
            System.out.println("Please ente your fractions in the form a/b, where a and b are integers.");
            seperator();
            String oper = getOperation(INPUT);
            if (oper.equalsIgnoreCase("q")) {
                break;
            }
            Fraction f1 = getFraction(INPUT);
            Fraction f2 = getFraction(INPUT);
            if (oper.equals("+")) {
                Fraction fres = f1.add(f2);
                fres.toLowestTerms();
                System.out.println(f1.toString() + " + " + f2.toString() + " = " + fres.toString());
            }
            if (oper.equals("-")) {
                Fraction fres = f1.subtract(f2);
                fres.toLowestTerms();
                System.out.println(f1.toString() + " - " + f2.toString() + " = " + fres.toString());
            }
            if (oper.equals("*")) {
                Fraction fres = f1.multiply(f2);
                fres.toLowestTerms();
                System.out.println(f1.toString() + " * " + f2.toString() + " = " + fres.toString());
            }
            if (oper.equals("/")) {
                Fraction fres = f1.divide(f2);
                fres.toLowestTerms();
                System.out.println(f1.toString() + " / " + f2.toString() + " = " + fres.toString());
            }
            if (oper.equals("=")) {
                System.out.println(f1.toString() + " = " + f2.toString() + " is " + f1.equals(f2));
            }
            seperator();
        }
    }

    public static void seperator() {
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static String getOperation(Scanner input) {
        String[] choices = {"+", "-", "/", "*", "=", "q", "Q"};
        String oper;
        boolean contains = false;
        System.out.println("Please enter an operation(+, - , / , *, = or Q to quit): ");
        oper = input.next();
        contains = isOperator(oper, choices);
        while (!contains) {
            System.out.println("Invalid input (+, - , / , *, = or Q to quit): ");
            oper = input.next();
            contains = isOperator(oper, choices);
        }
        return oper;
    }

    public static boolean isOperator(String oper, String[] choices) {
        for (String Op : choices) {
            if (oper.equals(Op)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validFraction(String input) {
        if (input.contains("-") && input.indexOf("-", 1) != -1) {
                return false;
        }
        if (input.contains("/")) {
            if (input.indexOf("/") == input.length() - 1) {
                return false;
            }
            String num = input.substring(0, input.indexOf("/"));
            String denom = input.substring(input.indexOf("/") + 1);
            return isNumber(num) && isNumber(denom) && Integer.parseInt(denom) != 0;
        }
        return isNumber(input); // catch exception if user typed in a none numbers value
    }

    public static boolean isNumber(String num) {
        if (num.isEmpty()) {
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Fraction getFraction(Scanner input) {
        int num, denom;
        System.out.println("Please enter a fraction (a/b) or integers (a): ");
        String fraction = input.next();
        while (!validFraction(fraction)) {
            System.out.println("Invalid fraction.Please enter (a/b) or (a). Where a and b are integers and b is not a zero: ");
            fraction = input.next();
        }
        if (fraction.contains("/") && fraction.indexOf("/") < fraction.length() - 1) {
            num = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
            denom = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
            return new Fraction(num, denom);
        }
        return new Fraction(Integer.parseInt(fraction));
    }
}
