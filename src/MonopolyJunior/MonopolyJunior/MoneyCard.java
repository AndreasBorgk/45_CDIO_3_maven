package MonopolyJunior;

public class MoneyCard extends ICards {
    int value;


    public MoneyCard(String name, int value) {
        super(name);
        this.value = value;
    }

    @Override
    void handlePlayer(Player player) {
        player.addBalance(value); // adds or substracts the value given by the card

        System.out.println("you got a money card. you get: " + value + " $");
    }
}
