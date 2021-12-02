package Module13.Results;

public class Horse extends Thread{

    private long distance = 100_000_000_000L;
    public String name;
    public int speed;

    public Horse(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        if (distance > 0){
            this.distance = distance;
        }else {
            System.out.println("Не допускается устанавливать значение дистанции меньше или равное 0");
        }
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (distance > 0){
            distance -= speed;
        }
        long end = System.currentTimeMillis();
        System.out.println(name + " пришла к финишу. Время работы потока " + (end-start) + "ms");
    }

}
