package MonopolyJunior;

public class Board {
    private Field[]fields = new Field[24];


    public Board()
    {
        int i = 0;
        fields[i++] = new Field("Start", 2);
        fields[i++] = new Field("Burgerbar", 1);
        fields[i++] = new Field("Pizzahuset",1);
        fields[i++] = new Field("Chance Kort",0);
        fields[i++] = new Field("Slikbutikken",1);
        fields[i++] = new Field("Iskiosken",1);
        fields[i++] = new Field("På besøg",0);
        fields[i++] = new Field("Museet",2);
        fields[i++] = new Field("Biblioteket",2);
        fields[i++] = new Field("Chance kort",0);
        fields[i++] = new Field("Skaterparken",2);
        fields[i++] = new Field("Swimmingpoolen",2);
        fields[i++] = new Field("Gratis Parkering",0);
        fields[i++] = new Field("Spillehallen",3);
        fields[i++] = new Field("Biografen",3);
        fields[i++] = new Field("Chance Kort",0);
        fields[i++] = new Field("Legetøjs butikken",3);
        fields[i++] = new Field("Dyre handlen",3);
        fields[i++] = new Field("Gå i Fængsel",0);
        fields[i++] = new Field("Bowling hallen",4);
        fields[i++] = new Field("Zoo",4);
        fields[i++] = new Field("Chance Kort", 0);
        fields[i++] = new Field("Vandlandet",5);
        fields[i++] = new Field("Strandpromenaden",5);

    }
    public Field getField(int location) {
        return fields[location];
    }

}
