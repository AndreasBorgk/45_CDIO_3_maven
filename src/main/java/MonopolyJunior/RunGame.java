package MonopolyJunior;

import gui_fields.GUI_Street;
import gui_fields.GUI_Player;
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


        private static String playerName() {
            // asks for the players name and return the name.
            String nameVal = gui.getUserString("what is your name? ");

            return nameVal;
        }

        private static int playerAge() {
            // asks for the players age and return the age.
            int ageVal = gui.getUserInteger("How old are you? ");


            return ageVal;
        }


        private static int getPlayerCount() {
            // asks how many players plays.

            while (true) {
                playerCount =  gui.getUserInteger("How many are playing?",2,4);

                if(playerCount < 2) {
                    gui.showMessage("You are not enough players.");
                }  else if (playerCount > 4) {
                    gui.showMessage("you are too many players");
                }  else {
                    gui.showMessage(playerCount + " players are playing.");
                    GUIplayers = new GUI_Player[playerCount];
                    return playerCount;
                }
                // if statement to check that there is only between 2 and 4 players.
                // if the number typed is different from 2,3 or 4. it will ask again
            }
        }

        private static int calcStartAmount() {
            int startAmount = 0;

            switch(playerCount){
                // sets the startamount defined by number of players.
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
            gui.showMessage("Rules for Monopoly Junior: \n");
            gui.showMessage("1. You have to be between 2 and 4 players. \n" +
                    "2. if youre 2 players, you start with 20M. if you're 3 you start with 18M, " +
                    "and if youre 4 you start with 16M\n" +
                    "3. The game will be played as followed: \n" +
                    "You start by rolling the dice and move the following facevalue on the field.\n" +
                    "If you land on a field without an owner, you have to buy it." +
                    "If the field has an owner, you have to pay him rent \n");

            gui.showMessage("If you land on go to jail, you will go to the jail field, and either pay 1M to get out," +
                    "or use your jailcard. \n" +
                    "Everytime you pass start, you'll receive 2M. \n"+
                    "The game is done, when a player happens to be broke, which means he has negative balance. \n" +
                    "The winner is the one with most money on hand");
            getPlayerCount();

            int startAmount = calcStartAmount();

            players = new Player[playerCount];
            // makes a player array


            for (int i = 0; i < playerCount; i++) {
                //asks for players name, age and adds balance for the lenght of the array.

               players[i] = new Player(playerName(), playerAge(), new Balance(startAmount));

               players[i].setGUIid(i);

                addguiplayer(i, players[i].getName(), players[i].getBalance());

                gui.showMessage(players[i].getName() + " is " + players[i].getAge() + " years old. ");

            }

        }

        private static void amountOfMoney() {

            for (int i = 0; i < playerCount; i++) {

                // prints out the name of player index and his balance.
                gui.showMessage(players[i].getName() + " " +
                        "ended the game with the money: M" + players[i].getBalance());
            }
        }

        private static Player winnerOfGame() {
                Player winnerOfGame= null;

                for(Player player:players){
                    // sets the winner of the game to player with the most money.

                    if(winnerOfGame == null || winnerOfGame.getBalance() < player.getBalance()){
                        winnerOfGame = player;
                    }
                }
                return winnerOfGame;
            }


        private static boolean handleIfPlayerHasGetOutOfPrisonCard(Player currentPlayer){
            if(currentPlayer.hasGetOutOfPrisonCard()){
                // checks if the player has a get out of jail card. If he has = true else return false
                // if he has, he uses it and gets released.
                // sets the jailCard = false


                currentPlayer.gottenOutOfPrisonCard();


                currentPlayer.prisonCardUsed();
                return true;
            }
            return false;
        }



        private static boolean handleIfPlayerIsInJail(Player currentPlayer) {
            if(currentPlayer.isInJail()){
                // checks if the player is in jail

                if(currentPlayer.hasGetOutOfPrisonCard()){
                    handleIfPlayerHasGetOutOfPrisonCard(currentPlayer);
                    // checks if the player has a get out of jail card
                    // if he has he uses it

                } else {
                    // else he pays a fine to get out of jail
                    currentPlayer.payFine(1);
                    gui.showMessage("you are in jail, and have to pay 1M to get out");
                }

                currentPlayer.releaseFromJail();
                // puts the player of jail.
                return true;
            }
            return false;


        }
        private static void handleField(Player currentPlayer) {
            IField f = b.getField(currentPlayer.getLocation());
            
            f.handlePlayer(currentPlayer);
            // handle the player opportunities given by the field landed on
        }



        private static boolean handleIfPlayerIsOnVacation(Player currentPlayer){
            if(currentPlayer.isOnVacation()){
                // checks if the person is on vacation/parking spot

                currentPlayer.homeFromVacation();
                // if on vacation set him home from vacation/parking spot
               return true;
            }
            return false;
        }


        private static void printOutFieldInfo(Player currentPlayer){
            System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue());

            gui.showMessage("You landed on field:  " + currentPlayer.getLocation() + ", " + fieldName(currentPlayer));
            // prints out the roll of the dice and his new location and what field it is
        }



        private static Player setCurrentPlayer(int index){
            currentPlayer = players[index % playerCount];
            return currentPlayer;
            // defines the current player by his index number running in the loop of playercount
        }



        private static Player nextPlayersTurn(){

          currentPlayerNumber = (currentPlayerNumber +1) % playerCount;
          // sets the currentplayer by starting from and adds 1 to give a new player the turn
          currentPlayer = players[currentPlayerNumber];
          return currentPlayer;
        }



        private static void doTurn() {
            //used from CDIO1, with changes.
            gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], false);
                if (handleIfPlayerIsOnVacation(currentPlayer)) return;
                // checks if he is on the parking spot

                if (handleIfPlayerIsInJail(currentPlayer)) return;
                // checks if he is in jail


                if (gui.getUserLeftButtonPressed(" ", "Roll Die", " ")) {
                    currentPlayer.roll();
                }
                ; // player rolls the dice
                gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], true);
                gui.setDie(currentPlayer.getFaceValue());
                printOutFieldInfo(currentPlayer);


                gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], false);
                handleField(currentPlayer);
                gui.getFields()[currentPlayer.getLocation()].setCar(GUIplayers[currentPlayer.getGUIid()], true);

                GUIplayers[currentPlayer.getGUIid()].setBalance(currentPlayer.getBalance());

                gui.showMessage("new balance for " + currentPlayer.getName() + " is: " + currentPlayer.getBalance());


        }


        

        private static void playGame() { // used from cdio 1, with changes.
            setCurrentPlayer(0);
            do {
                doTurn(); // tells the player to do his turn
                nextPlayersTurn(); // tells te next player in the array to do his turn
            } while(!currentPlayer.isGameDone()); // checks if the player is broke in a loop

            if (currentPlayer.isGameDone()) {

                gui.showMessage(currentPlayer.getName() + " is broke and has lost the game");
                amountOfMoney();
                // prints out the player name and tells him he is broke
                // prints out the value the players balance.

                gui.showMessage("the winner of the game is: " + winnerOfGame().getName());
                // gets the winner of the game by name and total money

            }


            }





            private static void newGame() { // Used from cdio1, but with changes.
                setupGame();
                playGame();



            }




        public static void main(String[] args) {
            newGame();

        }
    }

