package MonopolyJunior;

public class Property extends IField {
    private Player owner;
    private int price;

    public Property(String name, int price){
        super(name);
        this.price = price;
        owner = null;
    }


    public void handlePlayer(Player player) {

        if(owner == null)
        {
            player.buyProperty(price);
            owner = player;
        }
        else if (owner != player)
        {
            player.payRent(price);
        }
        else;
    }


}
