package Module10;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        writeToFile("src/main/java/Module10/source.txt", "src/main/java/Module10/destination.txt");
    }

    public static void writeToFile(String source, String destination) {
        int maxLength = 0;
        String maxStringLength = null;
        int maxWords = 0;
        String maxStringWords = null;
        String readLine;

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination, true))) {
            while ((readLine = reader.readLine()) != null) {
                if (readLine.length() >= maxLength) {
                    maxLength = readLine.length();
                    maxStringLength = readLine;
                }
                String words[] = readLine.split(" ");
                if (words.length >= maxWords) {
                    maxWords = words.length;
                    maxStringWords = readLine;
                }
            }
            writer.write("Самая длинная строка: " + maxStringLength + ". Её длина: " + maxLength + ";\n" +
                    "Максимальное количество слов в строке: " + maxStringWords + ". Количество слов: " + maxWords + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
