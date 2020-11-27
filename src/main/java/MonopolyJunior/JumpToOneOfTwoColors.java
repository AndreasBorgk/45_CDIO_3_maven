package MonopolyJunior;

import java.util.Properties;
import java.util.Scanner;

import static MonopolyJunior.RunGame.gui;

public class JumpToOneOfTwoColors extends ICards {
    private String color1;
    private String color2;
    int price;
    private Board b;
    Scanner sc = new Scanner(System.in);


    public JumpToOneOfTwoColors(String name, int price, String color1, String color2, Board b) {
        super(name);
        this.price = price;
        this.color1 = color1;
        this.color2 = color2;
        this.b = b;
    }

    private String selectedColor(){
        gui.showMessage("Would you like to jump to " + color1 + " , press 1. Jump to " + color2 + ", press 2.");
            // gives us the opportunity to choose between the two colors asked. returns the chosen color.
        boolean chosenColor = (gui.getUserLeftButtonPressed("Choose color ", "1", "2"));
        if(chosenColor == true){
            return color1;
        } else
        return color2;
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
        Property[]properties = b.getPropertiesByColor(selectedColor());

        Property playerSelectedProperty = selectedProperty(properties);

        player.setLocation(b.getPropertyLocation(playerSelectedProperty));

        playerSelectedProperty.handlePlayerExtended(player,true);


    }
}
