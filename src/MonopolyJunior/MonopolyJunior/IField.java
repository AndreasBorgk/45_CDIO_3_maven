package MonopolyJunior;

public abstract class IField {
    private Player owner;
    public String name = "";
    public IField(String name){
        this.name = name;
    }

    public Player setOwner(){
        return owner;
    }

    public Player getOwner(){
        return owner;
    }
    abstract void handlePlayer(Player player);
}
