package MonopolyJunior;

public class BuyIfFreePayIfOwnedCard extends ICards {
int location;
int price;

    public BuyIfFreePayIfOwnedCard(String name, int price, int location) {
        super(name);
        this.location = location;
        this.price = price;

    }

    @Override
    void handlePlayer(Player player) {
        player.setLocation(player.getFaceValue());

    }
}
