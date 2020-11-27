package MonopolyJunior;

import java.util.Scanner;

public class JumpToOneColor extends ICards {
private String color;
int price;
private Board b;
Scanner sc = new Scanner(System.in);

    public JumpToOneColor(String name, int price, String color, Board b) {
        super(name);
        this.price = price;
        this.color = color;
        this.b = b;
    }

    private String givenColor(){ // shows us which color the card tells us to go to.
        System.out.println("You got a card where you can jump to a building on the following color: " + color);
            return color;
    }


    private Property selectedProperty(Property[]properties) {
        // Gives us the opportunity to jump to either of the colored properties
        System.out.println("Would you like to jump to " + properties[0].name + " press 1. Jump to " + properties[1].name + ", pres 2");
        int chosenProperty = sc.nextInt();

        if (chosenProperty == 1) {
            return properties[0];
        } else
            return properties[1];
    }

    @Override
    void handlePlayer(Player player) {
        Property[]properties = b.getPropertiesByColor(givenColor());
            // calls the function from our board by the given color. returns the properties with color.

        Property playerSelectedProperty = selectedProperty(properties);
            // returns the property chosen by selectedProperty

        player.setLocation(b.getPropertyLocation(playerSelectedProperty));
            //  sets us to the chosen Property location

        playerSelectedProperty.handlePlayerExtended(player,true);
            // handles the player given if the property is free or not

    }
}
