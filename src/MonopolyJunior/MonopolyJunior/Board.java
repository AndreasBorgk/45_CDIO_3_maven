package MonopolyJunior;

public class Board {
    private IField[]fields = new IField[24];




    public Board()
    {
        int i = 0;
        fields[i++] = new Field("Start", 2);
        Property burgerbar = new Property("Burgerbar", 1);
        fields[i++] = burgerbar;
        Property pizzahuset = new Property("Pizzahuset",1);
        fields[i++] = pizzahuset;
        burgerbar.setAssociation(pizzahuset);
        pizzahuset.setAssociation(burgerbar);


        fields[i++] = new Field("Chance Kort",0);

        Property slikbutikken = new Property("Slikbutikken",1);
        fields[i++] = slikbutikken;
        Property iskiosken = new Property("Iskiosken",1);
        fields[i++] = iskiosken;
        slikbutikken.setAssociation(iskiosken);
        iskiosken.setAssociation(slikbutikken);


        fields[i++] = new Jail("På besøg");

        Property museet = new Property("Museet",2);
        fields[i++] = museet;
        Property biblioteket = new Property("Biblioteket",2);
        fields[i++] = biblioteket;
        museet.setAssociation(biblioteket);
        biblioteket.setAssociation(museet);


        fields[i++] = new Field("Chance kort",0);

        Property skaterparken = new Property("Skaterparken",2);
        fields[i++] = skaterparken;
        Property swimmingpoolen = new Property("Swimmingpoolen",2);
        fields[i++] = swimmingpoolen;
        skaterparken.setAssociation(swimmingpoolen);
        swimmingpoolen.setAssociation(skaterparken);

        fields[i++] = new Field("Gratis Parkering",0);

        Property spillehallen = new Property("Spillehallen",3);
        fields[i++] = spillehallen;
        Property biografen = new Property("Biografen",3);
        fields[i++] = biografen;
        spillehallen.setAssociation(biografen);
        biografen.setAssociation(spillehallen);


        fields[i++] = new Field("Chance Kort",0);

        Property legetøjsbutik = new Property("Legetøjs butikken",3);
        fields[i++] = legetøjsbutik;
        Property dyrehandlen = new Property("Dyre handlen",3);
        fields[i++] = dyrehandlen;
        legetøjsbutik.setAssociation(dyrehandlen);
        dyrehandlen.setAssociation(legetøjsbutik);


        fields[i++] = new GoToJail("Gå i Fængsel");

        Property bowlinghallen = new Property("Bowling hallen",4);
        fields[i++] = bowlinghallen;
        Property zoo = new Property("Zoo",4);
        fields[i++] = zoo;
        bowlinghallen.setAssociation(zoo);
        zoo.setAssociation(bowlinghallen);


        fields[i++] = new Field("Chance Kort", 0);


        Property vandlandet = new Property("Vandlandet",5);
        fields[i++] = vandlandet;
        Property strandpromenaden = new Property("Strandpromenaden",5);
        fields[i++] = strandpromenaden;
        vandlandet.setAssociation(strandpromenaden);
        strandpromenaden.setAssociation(vandlandet);

    }


    public IField getField(int location) {
        return fields[location];
    }

}
