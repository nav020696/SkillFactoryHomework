package RolePlayingGame;


import RolePlayingGame.Players.Goblin;
import RolePlayingGame.Players.Hero;
import RolePlayingGame.Players.Player;
import RolePlayingGame.Players.Skeleton;
import RolePlayingGame.Seller.Seller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public static Hero hero = null;
    public static Seller seller;
    public static Fight fight;
    public static boolean isGameContinues = true;
    private static BufferedReader reader;

    public static void main(String[] args) {
        System.out.println("Введите имя персонажа");
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            heroesInitialization(reader.readLine());
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
                trading();
                break;
            case "2":
                fight();
                break;
            case "3":
                isGameContinues = false;
                break;
            case "4":
                playersChoice("1");
                break;
            case "5":
                playersChoice("2");
                break;
            default:
                break;
        }
    }


    public static Player generateMonster() {
        int random = (int) (Math.random() * 100);
        if (random % 2 == 0) {
            return new Goblin("Goblin", 50, 10, 10, 100, 20);
        } else {
            return new Skeleton("Skeleton", 30, 15, 15, 150, 15);
        }
    }

    public static void trading() throws IOException {
        System.out.println("Стоимость одного зелья " + seller.getPotion().getPrice() + " золотых монет.");
        System.out.println("Хотите знать количество монет у вашего героя? (да/нет)");
        if (reader.readLine().equals("да")) {
            System.out.println("У вашего героя " + hero.getGold() + " золотых монет");
        }
        System.out.println("Введите количество зелья, которое вам необходимо купить.");
        int count = 0;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Вы ввели не числовое значение");
        }
        int sum = seller.sell(count); //возвращаем количество денег, которое нам нужно для покупки зелья;
        //проверяем, хватит ли у нашего героя денег
        if (hero.getGold() - sum >= 0 && sum != 0) {
            hero.setGold(hero.getGold() - sum);
            hero.setHealth(hero.getHealth() + 100 * count);
            System.out.println("Вы купили " + count + " склянок с зельем. Здоровье героя увеличено на " + hero.getHealth() + "ед.");
            System.out.println("Остаток золотых монет у героя " + hero.getGold() + ".");
        } else if (sum == 0) {
            System.out.println("Количество зелья для покупки 0");
        }else {
            System.out.println("У героя недостаточно денежных средств");
        }
        System.out.println("4. Продолжить торговлю");
        System.out.println("6. Вернуться в город");
        playersChoice(reader.readLine());
    }

    public static void fight() throws IOException {
        fight.fight(hero, generateMonster());
        System.out.println("5. Продолжить бой");
        System.out.println("6. Вернуться в город");
        playersChoice(reader.readLine());
    }

    public static void heroesInitialization(String heroName){
        hero = new Hero(heroName, 1000, 20, 50);
        seller = new Seller();
        fight = new Fight();
    }
}
