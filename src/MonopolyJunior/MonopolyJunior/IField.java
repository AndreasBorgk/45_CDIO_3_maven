package MonopolyJunior;

public abstract class IField {
    public String name = "";
    public IField(String name){
        this.name = name;
    }
    abstract void handlePlayer(Player player);
}
