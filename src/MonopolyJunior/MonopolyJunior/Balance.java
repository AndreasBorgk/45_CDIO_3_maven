package MonopolyJunior;

public class Balance {
    private int value;
    private int defaultValue;

    public Balance(int value) {
        this.value = value;
        this.defaultValue = value;
    }

    public Balance()
    {
        defaultValue = 0;
        reset();
    }

    public void add(int value){
        this.value += value;

    }

    public int get(){
        return value;
    }

    public void reset(){
        value = defaultValue;
    }
}
