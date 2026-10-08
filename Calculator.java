public class Calculator{

    public static void main (String[] args) {

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        switch(args[2]){
            case "+":
                System.out.println(add(num1, num2));
                break;

            case "-":
                System.out.println(subtract(num1, num2));
                break;

            case "*":
                System.out.println(multiply(num1, num2));
                break;

            case "/":
                System.out.println(divide(num1, num2));
                break;

            default:
                System.out.println("Unknown Operator");
        }

    }

    public static int add(int n1, int n2){
        return n1 + n2;
    }

    public static int subtract(int n1, int n2){
        return n1 - n2;
    }

    public static int multiply(int n1, int n2){
        return n1 * n2;
    }

    public static int divide(int n1, int n2){
        return n1 / n2;
    }
}