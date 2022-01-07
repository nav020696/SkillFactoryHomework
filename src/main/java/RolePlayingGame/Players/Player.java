package RolePlayingGame.Players;

public abstract class Player {
    private String name;
    private int health;
    private int gold;
    private int dexterity; //ловкость
    private int experience; //опыт
    private int power; //сила

    public Player(String name, int health, int gold, int dexterity, int experience, int power) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.experience = experience;
        this.power = power;
    }

    public int attack(){
        int i = (int)(Math.random() * 100);
        if (i >= 90) return power * 2;
        if (i < dexterity * 3) return power;
        return 0;
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
