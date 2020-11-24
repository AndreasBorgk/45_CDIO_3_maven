package MonopolyJunior;

public class GoToJail extends IField {
    private int jailLocation;
    private int fine;

    public GoToJail(String name, int fine, int jailLocation){
        super(name);
        this.jailLocation = jailLocation;
        this.fine = fine;
        //owner = null;
    }


    public void handlePlayer(Player player) {
        player.setInJail();
        player.setLocation(jailLocation);
    }
}
