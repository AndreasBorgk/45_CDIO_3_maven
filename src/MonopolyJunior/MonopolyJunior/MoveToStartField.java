package MonopolyJunior;

public class MoveToStartField extends ICards {
    private int startLocation;
    public MoveToStartField(String name, int startLocation) {
        super(name);
        this.startLocation = startLocation;
    }

    @Override
    void handlePlayer(Player player) {
        player.setLocation(0);
        player.getStartMoney();

    }
}
