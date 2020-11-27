package MonopolyJunior;

import MonopolyJunior.IField;

import static MonopolyJunior.RunGame.gui;

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
            return false; // checks if the property has an owner
        return getOwner() == associated.getOwner();
        // checks if the associated fields have same owner
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
                // if the property is not free given the chance card you buy
                player.buyProperty(price);
            }

            // sets the owner = currentplayer as he has gotten it for free if the property is free
            owner = player;
            gui.showMessage("this property had no owner, new owner is: " + player.getName());
        }
        else if (owner != player)
        {
            // if the owner is different from the currentplayer he pays rent
            gui.showMessage("this property is owned by " + owner.getName() + " , pay rent price");

            handleRent(player);
            gui.showMessage(owner.getName() + " gets payed: " + price + ". His new balance is: " + owner.getBalance());
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
            // makes currentplayer pay double rent if the two associated properties have same owner
            gui.showMessage("This field is owned by " + owner + "the associated field is owned by him aswel. you pay double rent");
            calcPrice = price * 2;
            player.payRent(calcPrice);
            owner.getRent(calcPrice);

        }else
            // if the properties doesnt have the same owner pay normal rent
            player.payRent(price);
            owner.getRent(price);
    }


}
