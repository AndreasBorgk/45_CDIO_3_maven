package MonopolyJunior;

public class MoveExactNumberOfFields extends ICards{
    private int moveNumberOfFields;
    public MoveExactNumberOfFields(String name, int moveNumberOfFields) {
        super(name);
        this.moveNumberOfFields = moveNumberOfFields;

    }

    @Override
    void handlePlayer(Player player) {
        player.setLocation(moveNumberOfFields + player.getLocation());
            // moves the number of fields given by the card from your current location.

        System.out.println("new position for player is: " + player.getLocation());
    }
}
