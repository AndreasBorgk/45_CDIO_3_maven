package MonopolyJunior;

public class Dice {
        private final int MAX = 6;
        private int faceValue;

        public Dice()
        {

        }

        public void roll() // used from CDIO 1 and 2 with changes
        {
            faceValue = (int)(Math.random()* MAX +1); // Ruller et tilfældigt tal mellem 1 og 6
        }

        public int getFaceValue()
        {
            return faceValue;
        }
    }


