package MonopolyJunior;

import java.util.Scanner;

import static MonopolyJunior.RunGame.gui;

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
        gui.showMessage("You got a card where you can jump to a building on the following color: " + color);
            return color;
    }


        private Property selectedProperty(Property[]properties){
            gui.showMessage("Would you like to jump to " + properties[0].name + " press 1. Jump to " + properties[1].name + ", pres 2");
            // gives us the opportunity to choose between the two properties by the color chosen
            boolean chosenProperty = (gui.getUserLeftButtonPressed("Choose property ", "1", "2"));
            if(chosenProperty == true){
                return properties[0];
            }
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
