package MonopolyJunior;

public class Property extends IField {
    private Player owner;
    private int price;
    private Property associated;

    public String getColor() {
        return color;
    }

    private String color;


    public boolean propertiesHaveSameOwner()
    {
        if(getOwner() == null)
            return false;
        return getOwner() == associated.getOwner();
    }


    public Property(String name, int price, String color){
        super(name);
        this.price = price;
        owner = null;
        this.color = color;
    }

    public void handlePlayerExtended(Player player, boolean propertyIsFree){
        if(owner == null)
        {
            if(!propertyIsFree) {
                player.buyProperty(price);
            }
            owner = player;
            System.out.println("this property had no owner, new owner is: " + player.getName());
        }
        else if (owner != player)
        {
            System.out.println("this property is owned by " + owner.getName() + " , pay rent price");
            handleRent(player);
            System.out.println(owner.getName() + " gets payed: " + price + ". His new balance is: " + owner.getBalance());
        }

    }


    public void handlePlayer(Player player) {
        handlePlayerExtended(player,false);
    }

    public void setAssociation(Property associated){
        this.associated = associated;

    }

    public void handleRent(Player player){
        int calcPrice;
        if(propertiesHaveSameOwner()) {
            System.out.println("This field is owned by " + owner + "the associated field is owned by him aswel. you pay double rent");
            calcPrice = price * 2;
            player.payRent(calcPrice);
            owner.getRent(calcPrice);
        }else
            player.payRent(price);
            owner.getRent(price);
    }


}
