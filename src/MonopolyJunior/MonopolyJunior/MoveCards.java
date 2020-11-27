package MonopolyJunior;

public class MoveCards extends ICards {
    public int moveTo;



    public MoveCards(String name, int moveTo){
        super(name);
        this.moveTo = moveTo;

    }

    @Override
    void handlePlayer(Player player) {
        player.setLocation(moveTo); // move to the field given by the card.

        System.out.println("your card told you to move to the following field: " + moveTo);
        System.out.println(player.getLocation() + " is your new location"); // shows new location

    }
}
