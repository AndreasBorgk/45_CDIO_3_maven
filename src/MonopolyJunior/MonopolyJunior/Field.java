package MonopolyJunior;

public class Field extends IField {
    public String name;
    public int value;

    public Field(String name, int value) {
        super(name);
        this.name = name;
        this.value = value;
    }

    @Override
    void handlePlayer(Player player) {

    }
}
