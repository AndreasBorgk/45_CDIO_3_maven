package MonopolyJunior;

import static MonopolyJunior.RunGame.gui;

public class MoveCards extends ICards {
    public int moveTo;



    public MoveCards(String name, int moveTo){
        super(name);
        this.moveTo = moveTo;

    }

    @Override
    void handlePlayer(Player player) {
        player.setLocation(moveTo); // move to the field given by the card.

        gui.showMessage("your card told you to move to the following field: " + moveTo);
        gui.showMessage(player.getLocation() + " is your new location"); // shows new location

    }
}
