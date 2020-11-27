package MonopolyJunior;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
            int faceValue;
            @org.junit.jupiter.api.Test
            void roll() {


                for (int i = 0; i < 1000; i++) {

                    faceValue = (int)(Math.random()* 6 +1);
                    assertTrue(getFaceValue() >= 1 && getFaceValue() <= 6);
                }


            }

            public int getFaceValue() {
                return faceValue;
            }
        }
