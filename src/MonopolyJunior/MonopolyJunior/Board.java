package MonopolyJunior;

public class Board {
    private IField[]fields = new IField[24];
    private Property[]properties;
    public static final String BLUE = "Blue";
    public static final String GREEN = "Green";
    public static final String YELLOW = "Yellow";
    public static final String RED = "Red";
    public static final String ORANGE = "Orange";
    public static final String PURPLE = "Purple";
    public static final String LIGHTBLUE = "Lightblue";
    public static final String BROWN = "Brown";



    public Board()
    {
        int i = 0;
        fields[i++] = new Field("Start", 2);
        Property burgerbar = new Property("Burgerbar", 1, BROWN);
        fields[i++] = burgerbar;
        Property pizzahuset = new Property("Pizzahuset",1, BROWN);
        fields[i++] = pizzahuset;
        burgerbar.setAssociation(pizzahuset);
        pizzahuset.setAssociation(burgerbar);


        fields[i++] = new TakeChanceCard(this);

        Property slikbutikken = new Property("Slikbutikken",1, LIGHTBLUE);
        fields[i++] = slikbutikken;
        Property iskiosken = new Property("Iskiosken",1, LIGHTBLUE);
        fields[i++] = iskiosken;
        slikbutikken.setAssociation(iskiosken);
        iskiosken.setAssociation(slikbutikken);


        fields[i++] = new Jail("På besøg");

        Property museet = new Property("Museet",2, PURPLE);
        fields[i++] = museet;
        Property biblioteket = new Property("Biblioteket",2, PURPLE);
        fields[i++] = biblioteket;
        museet.setAssociation(biblioteket);
        biblioteket.setAssociation(museet);


        fields[i++] = new TakeChanceCard(this);

        Property skaterparken = new Property("Skaterparken",2, ORANGE);
        fields[i++] = skaterparken;
        Property swimmingpoolen = new Property("Swimmingpoolen",2, ORANGE);
        fields[i++] = swimmingpoolen;
        skaterparken.setAssociation(swimmingpoolen);
        swimmingpoolen.setAssociation(skaterparken);

        fields[i++] = new FreeParking("Gratis Parkering, tag en pause. Du springer en runde over");

        Property spillehallen = new Property("Spillehallen",3, RED);
        fields[i++] = spillehallen;
        Property biografen = new Property("Biografen",3, RED);
        fields[i++] = biografen;
        spillehallen.setAssociation(biografen);
        biografen.setAssociation(spillehallen);


        fields[i++] = new TakeChanceCard(this);

        Property legetøjsbutik = new Property("Legetøjs butikken",3, YELLOW);
        fields[i++] = legetøjsbutik;
        Property dyrehandlen = new Property("Dyre handlen",3, YELLOW);
        fields[i++] = dyrehandlen;
        legetøjsbutik.setAssociation(dyrehandlen);
        dyrehandlen.setAssociation(legetøjsbutik);


        fields[i++] = new GoToJail("Gå i Fængsel");

        Property bowlinghallen = new Property("Bowling hallen",4, GREEN);
        fields[i++] = bowlinghallen;
        Property zoo = new Property("Zoo",4, GREEN);
        fields[i++] = zoo;
        bowlinghallen.setAssociation(zoo);
        zoo.setAssociation(bowlinghallen);


        fields[i++] = new TakeChanceCard(this);


        Property vandlandet = new Property("Vandlandet",5, BLUE);
        fields[i++] = vandlandet;
        Property strandpromenaden = new Property("Strandpromenaden",5, BLUE);
        fields[i++] = strandpromenaden;
        vandlandet.setAssociation(strandpromenaden);
        strandpromenaden.setAssociation(vandlandet);

        properties = new Property[] {burgerbar, pizzahuset, slikbutikken, iskiosken, museet, biblioteket,
                skaterparken, swimmingpoolen, spillehallen, biografen, legetøjsbutik, dyrehandlen,
                bowlinghallen, zoo, vandlandet, strandpromenaden };
    }


    public Property[] getPropertiesByColor(String color){
        Property[] coloredProperties = new Property[2];
        int i = 0;
        for(Property property: properties){
            if(property.getColor() == color){
                coloredProperties[i] = property;
                i++;
            }
        }

        return coloredProperties;
    }

    public int getPropertyLocation(Property property){
        int i = 0;
        for(IField field : fields){
            if(field == property){
                return i;

            }
            i++;
        }
        return -1;
    }



    public IField getField(int location) {
        return fields[location];
    }

}
