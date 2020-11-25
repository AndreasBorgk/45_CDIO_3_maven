package MonopolyJunior;


import java.util.Scanner;

    class Main {

        private static Player players[];
        private static Board b = new Board();
        static Scanner sc = new Scanner(System.in);
        private static int currentPlayerNumber;
        private static int playerCount;
        private static Player currentPlayer;



        private static String fieldName(Player currentPlayer) // prints out the given locations
        // fieldname for the current player
        {
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
            System.out.println("what is your name? ");
            
            Scanner name = new Scanner(System.in);

            String nameVal = name.nextLine();

            return nameVal;
        }
        private static int playerAge() {
            System.out.println("How old are you? ");

            Scanner age = new Scanner(System.in);

            int ageVal = age.nextInt();

            return ageVal;
        }


        private static int getPlayerCount() {
            System.out.println("How many players are playing? ");
            Scanner amountScanner = new Scanner(System.in);

            while (true) {
                playerCount = amountScanner.nextInt();

                if(playerCount < 2) {
                    System.out.println("You are not enough players.");
                }  else if (playerCount > 4) {
                    System.out.println("you are too many players");
                }  else {
                    System.out.println(playerCount + " players are playing.");
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
            System.out.println("each player start with: " + startAmount);
            return startAmount;
        }


        private static void setupGame(){
            System.out.println("rule for our Monopoly Junior game: \n");

            getPlayerCount();

            int startAmount = calcStartAmount();

            players = new Player[playerCount];

            for (int i = 0; i < playerCount; i++) {

               players[i] = new Player(playerName(), playerAge(), new Balance(startAmount));

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
            System.out.println(currentPlayer.getName() + " rolls: " + currentPlayer.getFaceValue());

            System.out.println("You landed on field:  " + currentPlayer.getLocation() + ", " + fieldName(currentPlayer));
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
               System.out.println(currentPlayer.getName() + " press 'K' if you are ready to throw");
               sc.next(); // ask if theyre ready to throw, by pressing K they throw.

               handleIfPlayerIsInJail(currentPlayer);
               //handleSpecialChanceCard(currentPlayer);  // Chancekort hvor man skal springe til et felt før næste runde.
               currentPlayer.roll(); // player rolls the dice
               printOutFieldInfo(currentPlayer);

               handleField(currentPlayer);

               System.out.println("new balance for " + currentPlayer.getName() + " is: " + currentPlayer.getBalance());


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

