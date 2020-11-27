package MonopolyJunior;

import gui_fields.*;

import java.awt.*;

public class GUIBoard {
    private GUI_Field[] Fields = new GUI_Field[24];

    public GUI_Field[] getFields(){
        return Fields;
    }

    public GUIBoard() {

        int i = 0;
        Fields[i++] = new GUI_Street("Start","Får 2M hver gang man passerer","Start","0", Color.BLACK,Color.WHITE);
        Fields[i++] = new GUI_Street("Burgerbar", "Koster M1", "Burgerbar", "1", new Color(156, 52, 4), Color.BLACK);
        Fields[i++] = new GUI_Street("Pizzahuset", "Koster M1", "Pizzahuset", "1", new Color(156, 52, 4), Color.BLACK);
        Fields[i++] = new GUI_Street("?", "Træk et chance kort", "Træk et chance kort","0", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Slikbutikken", "Koster M1", "Slikbutikken", "1", new Color(169, 157, 232), Color.BLACK);
        Fields[i++] = new GUI_Street("Iskiosken", "Koster M1", "Iskiosken", "1", new Color(169, 157, 232), Color.BLACK);
        Fields[i++] = new GUI_Street("GUI_Field.Image.GoToJail", "I fængsel", "På Besøg / Fængsel", "0", Color.orange, Color.BLACK);
        Fields[i++] = new GUI_Street("Museet", "Koster M2", "Museet", "2", new Color(182, 125, 142), Color.BLACK);
        Fields[i++] = new GUI_Street("Bibliotek", "Koster M2", "Bibliotek", "2", new Color(182, 125, 142), Color.BLACK);
        Fields[i++] = new GUI_Street("?", "Træk et chance kort", "Træk et chance kort","0", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Skateparken", "Koster M2", "Skateparken", "2", new Color(250, 241, 151), Color.BLACK);
        Fields[i++] = new GUI_Street("Swimmingpoolen", "Koster M2", "Swimmingpoolen", "2", new Color(250, 241, 151), Color.BLACK);
        Fields[i++] = new GUI_Street("Gratis Parkering", "Gratis", "Gratis Parkering", "0", Color.RED, Color.BLACK);
        Fields[i++] = new GUI_Street("Spillehallen", "Koster M3", "Spillehallen", "3", new Color(181, 102, 75), Color.BLACK);
        Fields[i++] = new GUI_Street("Biografen", "Koster M3", "Biografen", "3", new Color(181, 102, 75), Color.BLACK);
        Fields[i++] = new GUI_Street("?", "Træk et chance kort", "Træk et chance kort","0", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Lejetøjsbutik", "Koster M3", "Lejetøjsbutik", "3", new Color(252, 254, 117), Color.BLACK);
        Fields[i++] = new GUI_Street("Dyrehandlen", "Koster M3", "Dyrehandlen", "3", new Color(252, 254, 117), Color.BLACK);
        Fields[i++] = new GUI_Street("GUI_Field.Image.Jail", "Gå i fængsel", "Gå i fængsel", "0", Color.blue, Color.BLACK);
        Fields[i++] = new GUI_Street("Bowlinghallen", "Koster M4", "Bowlinghallen", "4", new Color(12, 94, 30), Color.BLACK);
        Fields[i++] = new GUI_Street("Zoologisk have", "Koster M4", "ZOO", "4", new Color(12, 94, 38), Color.BLACK);
        Fields[i++] = new GUI_Street("?", "Træk et chance kort", "Træk et chance kort","0", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Vandfaldet", "Koster M5", "Vandfaldet", "5", new Color(0, 0, 250), Color.BLACK);
        Fields[i++] = new GUI_Street("Strandpromenaden", "Koster M5", "Strandpromenaden", "5", new Color(0, 0, 250), Color.BLACK);
    }

    public GUI_Field getFields(int location) { return Fields[location];}
}
