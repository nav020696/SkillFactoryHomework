package Module2;

public class Calculate {
    public double calculate(double a, double b, String operator) {
        switch (operator) {
            case "addition":
                return a + b;
            case "subtraction":
                return a - b;
            case "multiplication":
                return a * b;
            case "division":
                if (b == 0){
                    System.err.println("Деление на ноль");
                    return 0;
                }
                return a/b;
            default:
                System.out.println("Вы ввели некорректный оператор. Попробуйте ещё раз");
                return 0;
        }
    }
}
