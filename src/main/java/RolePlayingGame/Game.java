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

    public Hero hero;
    public Seller seller;
    public Fight fight;
    private boolean isGameOver = false;
    private static BufferedReader reader;

    public Game() {
        seller = new Seller();
        fight = new Fight();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Введите имя персонажа");
        try {
            game.hero = new Hero(reader.readLine(), 1000, 20, 50);
            game.run();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Игра завершена");

    }
    public void run() throws IOException { //запуск игры
        while (!isGameOver) {
            System.out.println("Куда вы хотите пойти? Введите цифру действия");
            System.out.println("1. К торговцу");
            System.out.println("2. В тёмный лес");
            System.out.println("3. На выход");
            System.out.println("*. Вывести информацию о герое игры");
            playersChoice(reader.readLine());
        }
    }

    public void playersChoice(String action) throws IOException {
        switch (action) {
            case "1":
                trading();
                break;
            case "2":
                fight();
                break;
            case "3":
                isGameOver = true;
                break;
            case "4":
                playersChoice("1");
                break;
            case "5":
                playersChoice("2");
                break;
            case "*":
                heroInformation();
                break;
            default:
                break;
        }
    }


    public Player generateMonster() {
        int random = (int) (Math.random() * 100);
        if (random % 2 == 0) {
            return new Goblin("Goblin", 400, 10, 10, 100, 350);
        } else {
            return new Skeleton("Skeleton", 300, 15, 15, 150, 250);
        }
    }

    public void trading() throws IOException {
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
            System.out.println("Вы купили " + count + " склянок с зельем. Здоровье героя увеличено до " + hero.getHealth() +
                    "ед здоровья. Остаток золотых монет у героя " + hero.getGold() + ".");
        } else if (sum == 0) {
            System.out.println("Количество зелья для покупки 0");
        }else {
            System.out.println("У героя недостаточно денежных средств");
        }
        System.out.println("4. Продолжить торговлю");
        System.out.println("6. Вернуться в город");
        playersChoice(reader.readLine());
    }

    public void fight() throws IOException {
        fight.fight(hero, generateMonster());
        if (fight.getWinner().equals("hero")) {
            System.out.println(hero.getName() + " победил и заработал 300 монет и 1ед опыта");
            hero.setGold(hero.getGold() + 300);
            hero.setExperience(hero.getExperience() + 1);
            System.out.println("5. Продолжить бой");
            System.out.println("6. Вернуться в город");
            playersChoice(reader.readLine());
        }else{
            System.out.println(hero.getName() + " проиграл :(");
            playersChoice("3");
        }
    }

    public void heroInformation(){
        System.out.println("Имя вашего героя: " + hero.getName() + ";");
        System.out.println("Здоровье вашего героя: " + hero.getHealth() + "ед;");
        System.out.println("Запас золотых монет вашего героя: " + hero.getGold() + ";");
        System.out.println("Ловкость вашего героя: " + hero.getDexterity() + "ед;");
        System.out.println("Уровень опыта вашего героя: " + hero.getExperience() + ";");
        System.out.println("Сила удара вашего героя: " + hero.getPower() + ".");
    }
}
