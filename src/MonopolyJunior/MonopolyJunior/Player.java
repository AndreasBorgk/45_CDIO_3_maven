package MonopolyJunior;

public class Player {
    private Balance startvalue;
    private String name;
    private Dice dice1;
    private int age;
    private int location = 0;
    private Balance balance;
    private int gamesWon = 0;
    private Boolean inJail = false;


    Player(String name, int age)
    {
        this.name = name;
        this.age = age;
        dice1 = new Dice();
        balance = new Balance();

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
        balance.add(-value);
    }


    public void payRent(int value){
        balance.add(-value);
    }

    public void payFine(int value) {
        balance.add(-value);
    }

    public void setInJail(){
        if(inJail = true){
            setLocation(location=6);
        }

    }

    public boolean isInJail() {
        if (location == 18){
            setLocation(6);
        }
        return inJail;
    }

    public void releaseFromJail() {
        inJail = false;
    }


    void roll() {
        dice1.roll();

        dice1.getFaceValue();

        location = (location + dice1.getFaceValue())%24;

    }

    int getFaceValue(){
        return dice1.getFaceValue();
    }
    public int setLocation(int location) {
        this.location = location;
        return location;
    }


    boolean isGameDone() {
        return balance.get() < 0;
    }

    public int getLocation() {
        return location;
    }

    void incGamesWon() {
        gamesWon++;
    }

    int getGamesWon() {
        return gamesWon;
    }

    void newGame(){
        location = 0;
        this.balance.reset(); // as we use balance.reset, we set value of our balance = 1000.

    }


}
