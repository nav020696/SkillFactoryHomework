package RolePlayingGame.Seller;

public class Seller {
    private Potion potion;

    public Seller() {
        potion = new Potion(100);
    }

    public int sell(int count){
        return count * potion.getPrice();
    }

    public Potion getPotion() {
        return potion;
    }
}
