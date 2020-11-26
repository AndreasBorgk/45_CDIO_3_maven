package MonopolyJunior;

public class TakeChanceCard extends IField{
    private ICards[]cards = new ICards[20];
    int chosenCard;
    private final int numberOfCards = 20;

    public TakeChanceCard(){
        super("Draw a Card");
        createChanceCardList();
    }


    private ICards pickACard() {

        chosenCard = (int) (Math.random() * numberOfCards);
        return cards[chosenCard];
    }

    @Override
    void handlePlayer(Player player) {
        System.out.println(player.getName() + " landed on a Chance card field. You may draw a card");

        pickACard().handlePlayer(player);
        System.out.println("you got the card: " + pickACard());


    }


    private void createChanceCardList() {
        int i = 0;
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to an Orange field. " +
                "If not owned get it for free, if owned pay rent.", 0,0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to an Orange or green field. " +
                "If not owned get it free, if owned pay rent.", 0,0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to a blue field," +
                " get it for free if no owner, or pay rent.", 0,0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to a pink our blue field." +
                " If not owned, get it for free. Else pay rent",0,0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to a red field. " +
                "If not owned get it for free, else pay rent.",0,0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to a lightblue or red field, " +
                "if not owned get it for free, else pay rent", 0,0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to a brown or yellow field, " +
                "if not owned get it for free, else pay rent", 0, 0);
        cards[i++] = new BuyIfFreePayIfOwnedCard("Move to a brown or yellow field, " +
                "if not owned get it for free, else pay rent", 0, 10);


        cards[i++] = new moveCards("Move to Strandpromenaden",23);
        cards[i++] = new moveCards("Move to Start and receive 2M",0);

        cards[i++] = new MoneyCard("You ate to much, pay 2M to the bank",-2);
        cards[i++] = new MoneyCard("Its your birthday, you receive 1M from all players",1);
        cards[i++] = new MoneyCard("You made all your homeworks, receive 2m from the bank",2);

        cards[i++] = new MoveExactNumberOfFields("Move up to 5 fields forward", 5);
        cards[i++] = new MoveExactNumberOfFields("Move 1 field forward or take another card", 1);

        cards[i++] = new GetOutOfPrisonCard("You got a jailcard, save it till you need it",true);
    }

}
