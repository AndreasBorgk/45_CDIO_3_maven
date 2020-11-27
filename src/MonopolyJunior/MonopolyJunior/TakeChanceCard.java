package MonopolyJunior;

public class TakeChanceCard extends IField{
    private final int NUMBER_OF_CARDS = 16;
    private ICards[]cards = new ICards[NUMBER_OF_CARDS];
    int chosenCard;
    private Board b;


    public TakeChanceCard(Board b){
        super("Draw a Card");
        this.b = b;
        createChanceCardList();
    }


    private ICards pickACard() {

        chosenCard = (int) (Math.random() * NUMBER_OF_CARDS %NUMBER_OF_CARDS);
        return cards[chosenCard];
    }

    @Override
    void handlePlayer(Player player) {
        ICards newCard = pickACard();
        System.out.println(player.getName() + " landed on a Chance card field. You may draw a card");
        System.out.println("you got the card: " + newCard.name);
        newCard.handlePlayer(player);


    }

    public ICards[] getCards() {
        return cards;
    }

    private void createChanceCardList() {
        int i = 0;
        cards[i++] = new JumpToOneColor("Move to an Orange field. " +
                "If not owned get it for free, if owned pay rent.", 0, Board.ORANGE,b);
        cards[i++] = new JumpToOneOfTwoColors("Move to an Orange or green field. " +
                "If not owned get it free, if owned pay rent.", 0, Board.ORANGE, Board.GREEN, b);
        cards[i++] = new JumpToOneColor("Move to a blue field," +
                " get it for free if no owner, or pay rent.", 0,Board.BLUE,b);
        cards[i++] = new JumpToOneOfTwoColors("Move to a pink our blue field." +
                " If not owned, get it for free. Else pay rent",0,Board.PURPLE, Board.BLUE, b);
        cards[i++] = new JumpToOneColor("Move to a red field. " +
                "If not owned get it for free, else pay rent.",0,Board.RED,b);
        cards[i++] = new JumpToOneOfTwoColors("Move to a lightblue or red field, " +
                "if not owned get it for free, else pay rent", 0,Board.LIGHTBLUE,Board.RED, b);
        cards[i++] = new JumpToOneOfTwoColors("Move to a brown or yellow field, " +
                "if not owned get it for free, else pay rent", 0, Board.BROWN,Board.YELLOW,b);
        cards[i++] = new JumpToOneOfTwoColors("Move to a brown or yellow field, " +
                "if not owned get it for free, else pay rent", 0, Board.BROWN,Board.YELLOW,b);


        cards[i++] = new MoveCards("Move to Strandpromenaden",23);

        cards[i++] = new MoveToStartField("Move to Start and receive 2M",0);

        cards[i++] = new MoneyCard("You ate to much, pay 2M to the bank",-2);
        cards[i++] = new MoneyCard("Its your birthday, you receive 1M from all players",1);
        cards[i++] = new MoneyCard("You made all your homeworks, receive 2m from the bank",2);

        cards[i++] = new MoveExactNumberOfFields("Move up to 5 fields forward", 5);
        cards[i++] = new MoveExactNumberOfFields("Move 1 field forward or take another card", 1);

        cards[i++] = new GetOutOfPrisonCard("You got a jailcard, save it till you need it",true);
    }

}
