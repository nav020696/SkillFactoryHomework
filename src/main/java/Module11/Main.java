package Module11;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try{
            countAmount("src/main/java/Module11/file.txt");
        }catch (CountNumbersException e){
            System.out.println(e.getMessage());
            System.out.println("Попытка подсчета неудачна");
        }
    }

    public static void countAmount(String fileName) throws CountNumbersException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = reader.readLine();
            String[] array = line.split(" ");
            if (array.length != 2) {
                throw new CountNumbersException("В файле расположено не 2 числа");
            }
            int sum = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
            writer.write("\nСумма чисел равна " + sum);
            System.out.println("Сумма чисел успешно записана в файл");
        } catch (NumberFormatException e) {
            System.out.println("В файле расположено не целое число");
        } catch (IOException e) {
            System.out.println("Ошибка в файлах");;
        }
    }
}
