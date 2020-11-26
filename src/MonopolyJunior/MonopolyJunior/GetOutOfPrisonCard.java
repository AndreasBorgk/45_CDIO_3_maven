package MonopolyJunior;

public class GetOutOfPrisonCard extends ICards {
    private boolean jailCard;
    public GetOutOfPrisonCard(String name, boolean jailCard) {
        super(name);
        this.jailCard = jailCard;
    }

    @Override
    void handlePlayer(Player player) {

    }
}
