package MonopolyJunior;

import static MonopolyJunior.RunGame.gui;

public class MoneyCard extends ICards {
    int value;


    public MoneyCard(String name, int value) {
        super(name);
        this.value = value;
    }

    @Override
    void handlePlayer(Player player) {
        player.addBalance(value); // adds or substracts the value given by the card

        gui.showMessage("you got a money card. you get: " + value + " $");
    }
}
