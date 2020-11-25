package MonopolyJunior;

public class GoToJail extends IField {
    private int jailLocation = 6;


    public GoToJail(String name){
        super(name);
        this.jailLocation = jailLocation;
        //owner = null;
    }


    public void handlePlayer(Player player) {
        player.setInJail();
        player.setLocation(jailLocation);
    }
}
