package MonopolyJunior;


import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.util.Scanner;

    class RunGame {

        private static Player players[];
        private static Board b = new Board();
        static Scanner sc = new Scanner(System.in);
        private static int currentPlayerNumber;
        private static int playerCount;
        private static Player currentPlayer;
        private static GUIBoard gb = new GUIBoard();
        private static GUI_Player[] GUIplayers;


        static GUI gui = new GUI(gb.getFields());



        private static String fieldName(Player currentPlayer) // prints out the given locations
        // fieldname for the current player
        {
            GUI_Street gf = (GUI_Street) gb.getFields(currentPlayer.getLocation());

            IField f = b.getField(currentPlayer.getLocation());
            return f.name;
        }

//        private static int fieldValue(Player currentPlayer)
//        // prints out the fieldValue for the current location.
//        {
//            IField f = b.getField(currentPlayer.getLocation());
//            return f.value;
//        }

        private static String playerName() {

            String nameVal = gui.getUserString("What is your name?");

            return nameVal;
        }

        private static int playerAge() {

            int ageVal = gui.getUserInteger("How old are you");

            return ageVal;
        }


        private static int getPlayerCount() {
            System.out.println("How many players are playing? ");
            Scanner amountScanner = new Scanner(System.in);

            while (true) {
                playerCount = gui.getUserInteger("How many are playing",2,4);

                if(playerCount < 2) {
                    System.out.println("You are not enough players.");
                }  else if (playerCount > 4) {
                    System.out.println("you are too many players");
                }  else {
                    System.out.println(playerCount + " players are playing.");
                    GUIplayers = new GUI_Player[playerCount];

                    return playerCount;
                }
            }
        }

        private static int calcStartAmount() {
            int startAmount = 0;

            switch(playerCount){
                case 2:
                    startAmount = 20;
                    break;

                case 3:
                    startAmount = 18;
                    break;
                default:
                    startAmount = 16;
                    break;
            }
            gui.showMessage("each player start with: " + startAmount);
            return startAmount;
        }

        private static void addguiplayer(int i, String name,int balance){

            GUIplayers[i] = new GUI_Player(name, balance);
            gui.addPlayer(GUIplayers[i]);

            gui.getFields()[0].setCar(GUIplayers[i], true);

        }


        private static void setupGame(){
            gui.showMessage("rule for our Monopoly Junior game: \n");

            getPlayerCount();

            int startAmount = calcStartAmount();

            players = new Player[playerCount];

            for (int i = 0; i < playerCount; i++) {

               players[i] = new Player(playerName(), playerAge(), new Balance(startAmount));

               players[i].setGUIid(i);

                addguiplayer(i, players[i].getName(), players[i].getBalance());

                System.out.println(players[i].getName() + " is " + players[i].getAge() + " years old. ");

            }

        }



        private static void handleIfPlayerIsInJail(Player currentPlayer) {
            if(currentPlayer.isInJail()){
                currentPlayer.payFine(2);
                currentPlayer.releaseFromJail();
            }
        }
        private static void handleField(Player currentPlayer) {
            IField f = b.getField(currentPlayer.getLocation());
            
            f.handlePlayer(currentPlayer);
        }

        private static void printOutFieldInfo(Player currentPlayer){
            gui.showMessage(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue());

            gui.showMessage("You landed on field:  " + currentPlayer.getLocation() + ", " + fieldName(currentPlayer));
        }

        private static Player setCurrentPlayer(int index){
            currentPlayer = players[index % playerCount];
            return currentPlayer;
        }

        private static Player nextPlayersTurn(){

          currentPlayerNumber = (currentPlayerNumber +1) % playerCount;
          currentPlayer = players[currentPlayerNumber];
          return currentPlayer;
        }


        private static void doTurn() {
            //used from CDIO1, with changes.
           do {
//               gui.showMessage(currentPlayer.getName() + " press 'K' if you are ready to throw");
//               sc.next(); // ask if theyre ready to throw, by pressing K they throw.


               handleIfPlayerIsInJail(currentPlayer);


               //handleSpecialChanceCard(currentPlayer);  // Chancekort hvor man skal springe til et felt før næste runde.

               gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], false);
               if (gui.getUserLeftButtonPressed(" ", "Roll Die", " ")) {
                   currentPlayer.roll();
               }; // player rolls the dice
               gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], true);
               printOutFieldInfo(currentPlayer);
               gui.setDie(currentPlayer.getFaceValue());

               gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], false);
               handleField(currentPlayer);
               gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], true);

               GUIplayers[currentPlayer.getGUIid()].setBalance(currentPlayer.getBalance());

               gui.showMessage("new balance for " + currentPlayer.getName() + " is: " + currentPlayer.getBalance());



            } while (currentPlayer.isInJail());
            } // the loop continues until a player hit the estimated value



        

        private static void playGame() { // used from cdio 1, with changes.
            int round = 1; // sets start round to 1.
            setCurrentPlayer(0);
            do {
                doTurn();
                nextPlayersTurn();
            } while(!currentPlayer.isGameDone());

            }





            private static void newGame() { // Used from cdio1, but with changes.
                setupGame();
            String another = "y";
                
            while (another.equalsIgnoreCase("y")) { // asks if they want to play again
                // if yes, newgame Method will be called.
                playGame();
                System.out.println();
                System.out.println("would you like to play again? (y/n)");
                another = sc.next();


            }

        }


        public static void main(String[] args) {
            newGame();

        }
    }

