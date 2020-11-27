package MonopolyJunior;

public class Player {
    private String name;
    private Dice dice1;
    private int age;
    private int location = 0;
    private Balance balance;
    private boolean inJail = false;
    private boolean onVacation = false;
    private boolean gotOutOfPrisonCard = false;


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
        balance.add(-value);
    }


    public void payRent(int value){
        balance.add(-value);
    }

    public void payFine(int value) {
        balance.add(-value);
    }

    public void getRent(int value) {
        balance.add(value);
    }

    public void addBalance(int value){
        balance.add(value);
    }


    public void setInJail(){
        inJail = true;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setOnVacation() {
        onVacation = true;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void homeFromVacation() {
        onVacation = false;
    }


    public void releaseFromJail() {
        inJail = false;
    }

    public void getStartMoney() {
        addBalance(2);
    }


    void roll() {
        dice1.roll();

        dice1.getFaceValue();

        location = (location + dice1.getFaceValue());

        if(location >= 24){
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
    }

    public int getLocation() {
        return location;
    }





}
