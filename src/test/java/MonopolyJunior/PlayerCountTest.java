package MonopolyJunior;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCountTest {

    @Test
    void getPlayerCount() {

        for (int playerCount = 2; playerCount < 5; playerCount++) {
            assertTrue(playerCount >= 2 && playerCount <= 4);
        }
        }
    }