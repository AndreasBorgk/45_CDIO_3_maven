package MonopolyJunior;

public abstract class ICards {
    public String name = "";
    public ICards(String name){
        this.name = name;
    }
    abstract void handlePlayer(Player player);
}
