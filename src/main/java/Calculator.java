public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Calculator <add|sub|mul|div> a b");
            return;
        }

        Calculator calc = new Calculator();
        String op = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        switch (op) {
            case "add": System.out.println(calc.add(a, b)); break;
            case "sub": System.out.println(calc.sub(a, b)); break;
            case "mul": System.out.println(calc.mul(a, b)); break;
            case "div": System.out.println(calc.div(a, b)); break;
            default:
                System.out.println("Unknown operation");
        }
    }
}
