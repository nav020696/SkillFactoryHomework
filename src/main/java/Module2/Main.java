package Module2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите первое число");
            double a = Double.parseDouble(reader.readLine());
            System.out.println("Введите операцию: addition, subtraction, multiplication, division");
            String operation = reader.readLine();
            System.out.println("Введите второе число число");
            double b = Double.parseDouble(reader.readLine());
            System.out.println("Результат " + calculate.calculate(a, b, operation));
        } catch (NumberFormatException e) {
            System.err.println("Введено некорректное числовое значение");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
