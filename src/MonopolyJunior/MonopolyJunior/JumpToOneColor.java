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

    private String givenColor(){
        System.out.println("You got a card where you can jump to a building on the following color: " + color);
            return color;
    }


    private Property selectedProperty(Property[]properties) {
        System.out.println("Would you like to jump to" + properties[0] + " press 1. Jump to " + properties[1] + ", pres 2");
        int chosenProperty = sc.nextInt();
        if (chosenProperty == 1) {
            return properties[0];
        } else
            return properties[1];
    }

    @Override
    void handlePlayer(Player player) {
        Property[]properties = b.getPropertiesByColor(givenColor());
        Property playerSelectedProperty = selectedProperty(properties);
        player.setLocation(b.getPropertyLocation(playerSelectedProperty));
        playerSelectedProperty.handlePlayerExtended(player,true);

    }
}
