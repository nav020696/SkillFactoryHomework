package RolePlayingGame;

import RolePlayingGame.Players.Player;

public class Fight {
    private boolean isWinner = false;
    private String winner = "monster";

    public void fight (Player hero, Player monster){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("Начинается битва между " + hero.getName() + " и " + monster.getName());
                while (!isWinner){
                    System.out.println("------Удар героя " + hero.getName() + "------");
                    int powerOfAttack = hero.attack();
                    System.out.println(chechPowerAttack(hero, powerOfAttack));
                    monster.setHealth(monster.getHealth() - powerOfAttack);
                    if (checkPlayerLost(monster)){
                        winner = "hero";
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("------Удар монстра " + monster.getName() + "------");
                    powerOfAttack = monster.attack();
                    System.out.println(chechPowerAttack(monster, powerOfAttack));
                    hero.setHealth(hero.getHealth() - powerOfAttack);
                    if (checkPlayerLost(hero)){
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPlayerLost(Player player){
        if (player.getHealth() <= 0){
            System.out.println(player.getName() + " не осталось здоровья");
            isWinner = true;
            return true;
        }else{
            System.out.println(player.getName() + " осталось здоровья " + player.getHealth());
            return false;
        }
    }

    private String chechPowerAttack(Player player, int powerofAttack){
        if (powerofAttack > 0){
            return player.getName() + " ударил с силой " + powerofAttack;
        }else {
            return player.getName() + " промахнулся";
        }
    }

    public String getWinner() {
        return winner;
    }

}
