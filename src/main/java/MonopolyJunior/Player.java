package MonopolyJunior;


public class Player {
    private String name;
    private Dice dice1;
    private int age;
    private int location = 0;
    private Balance balance;
    private boolean inJail = false; // puts player out of jail
    private boolean onVacation = false; // sets player out of parking
    private boolean gotOutOfPrisonCard = false; // returns that the player has no prisoncard
    int GUIid;

    public int getGUIid() {
        return GUIid;
    }

    public void setGUIid(int GUIid) {
        this.GUIid = GUIid;
    }

    Player(String name, int age, Balance balance){
        this.name = name;
        this.age = age;
        dice1 = new Dice();
        this.balance = balance;
    }


    String getName()
    {
        return name;
    }

    int getAge() {
        return age;
    }

    public int getBalance()
    {
        return balance.get();
    }

    public void buyProperty(int value) {
        balance.add(-value); // subtracts the value of the field bought from balance.
    }


    public void payRent(int value){
        balance.add(-value); // subtracts the value of the rent from balance
    }

    public void payFine(int value) {
        balance.add(-value); // subtracts the fine from your balance.
    }

    public void getRent(int value) {
        balance.add(value); // adds the rent to your balance
    }

    public void addBalance(int value){
        balance.add(value);
    }


    public void setInJail(){
        inJail = true; // sets the person inJail.
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setOnVacation() {
        onVacation = true; // sets the person on vacation while parking
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void homeFromVacation() {
        onVacation = false; // "releases" the person from parking. which means he can play next turn
    }


    public void releaseFromJail() {
        inJail = false; // releases the player from jail
    }

    public void getStartMoney() {
        addBalance(2); // hands the player 2 money to balance
    }


    void roll() { // used from CDIO1 and 2 with changes.
        dice1.roll();

        dice1.getFaceValue();

        location = (location + dice1.getFaceValue());

        if(location >= 24){ // makes the location run in a loop of field numbers.
            // makes the player only get money if he passes start by default
            location = location %24;
            getStartMoney();
        }

    }

    int getFaceValue(){
        return dice1.getFaceValue();
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void gottenOutOfPrisonCard(){
        gotOutOfPrisonCard = true;
    }

    boolean hasGetOutOfPrisonCard() {
        return gotOutOfPrisonCard;
    }

    public void prisonCardUsed(){
        gotOutOfPrisonCard = false;
    }

    boolean isGameDone() {
        return balance.get() < 0;
            // checks if a players balance is below 0.
    }

    public int getLocation() {
        return location;
    }





}
