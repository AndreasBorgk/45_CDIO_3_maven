package MonopolyJunior;

public class FreeParking extends IField {
    public FreeParking(String name) {
        super(name);
    }

    @Override
    void handlePlayer(Player player) {
        player.setOnVacation();
        }

    }

