package MonopolyJunior;

public class Balance {
    private int value;

    public Balance(int value) {
        this.value = value;

    }


    public void add(int value){
        this.value += value; // adds the value to our current balance

    }



    public int get(){
        return value;
    } // returns balance

}
