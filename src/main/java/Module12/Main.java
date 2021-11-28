package Module12;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Person, Integer> personMap = new HashMap<>();
        personMap.put(new Person("Alex", "Rodrigez", 25, "director"), 150000);
        personMap.put(new Person("Julia", "Mitchel", 21, "teacher"), 10000);
        personMap.put(new Person("Vadim", "Next", 33, "programmer"), 100000);
        personMap.put(new Person("Ksenia", "Kerimova", 26, "journalist"), 15000);
        personMap.put(new Person("Vladimir", "Kulikov", 26, "engineer"), 14500);

        personMap.entrySet().removeIf(entry -> entry.getValue() < 15000);

        for (Map.Entry<Person, Integer> pair: personMap.entrySet()) {
            System.out.println(pair.getKey() + " Summary income: " + pair.getValue());
        }
    }
}
