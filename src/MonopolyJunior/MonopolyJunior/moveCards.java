package MonopolyJunior;

public class moveCards extends ICards {
    public int moveTo;



    public moveCards(String name, int moveTo){
        super(name);
        this.moveTo = moveTo;

    }

    @Override
    void handlePlayer(Player player) {
        player.setLocation(moveTo);
        System.out.println("your card told you to move to the following field: " + moveTo);

    }
}
