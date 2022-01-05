package RolePlayingGame;


import RolePlayingGame.Players.Goblin;
import RolePlayingGame.Players.Hero;
import RolePlayingGame.Players.Player;
import RolePlayingGame.Players.Skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public static Hero hero = null;
    public static boolean isGameContinues = true;
    private static BufferedReader reader;

    public static void main(String[] args) {
        System.out.println("Введите имя персонажа");
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            hero = new Hero(reader.readLine(), 1000, 20, 50);
            while (isGameContinues) {
                System.out.println("Куда вы хотите пойти? Введите цифру действия");
                System.out.println("1. К торговцу");
                System.out.println("2. В тёмный лес");
                System.out.println("3. На выход");
                playersChoice(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Игра завершена");
        }

    }

    public static void playersChoice(String action) throws IOException {
        switch (action) {
            case "1":
                System.out.println("Торговец еще не вышел на работу");
                System.out.println("4. Вернуться в город");
                System.out.println("5. Продолжить торговлю");
                playersChoice(reader.readLine());
                break;
            case "2":
                Fight fight = new Fight();
                fight.fight(hero, generateMonster());
                System.out.println("6. Вернуться в город");
                System.out.println("7. Продолжить бой");
                playersChoice(reader.readLine());
                break;
            case "3":
                isGameContinues = false;
                break;
            case "4", "6":
                break;
            case "5":
                playersChoice("1");
                break;
            case "7":
                playersChoice("2");
                break;
            default:
                System.out.println("Я не знаю такую команду. Попробуйте ещё раз");
        }
    }


    public static Player generateMonster(){
        int random = (int) (Math.random()* 100);
        if (random % 2 == 0){
            return new Goblin("Goblin", 50, 10, 10, 100, 20);
        }else {
            return new Skeleton("Skeleton", 30, 15, 15, 150, 15);
        }
    }
}
