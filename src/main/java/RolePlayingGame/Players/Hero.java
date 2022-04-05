package RolePlayingGame.Players;

public class Hero extends Player {
    public Hero(String name, int gold, int dexterity, int power) {
        //считаем, что при создании игрока у него 1000ед здоровья и 1 уровень
        super(name, 1000, gold, dexterity, 1, power);
    }
}
