package Module13.Results;

public class Main {
    public static void main(String[] args) {
        Horse h1 = new Horse("Карамелька", 30);
        Horse h2 = new Horse("Ладныш", 33);
        Horse h3 = new Horse("Лизун", 29);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
