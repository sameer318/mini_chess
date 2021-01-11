import java.util.Scanner;

public class GameDemo {
    static Scanner kb = new Scanner(System.in);                                      // Scanner is used to take input from user
    static String inp;
    public static void main(String[] args){
        Board b = new Board();                                                       // Creates a game board
        Piece piece = new Piece();                                                   // Creates a new piece

        // Creating pieces of each type
        SlowPiece slowP = new SlowPiece();
        FastPiece fastP = new FastPiece();
        SlowFlexible slowflexP = new SlowFlexible();
        FastFlexible fastflexP = new FastFlexible();

        // Taking first input
        System.out.println("Enter a command (type help for details):");
        inp = kb.nextLine();



        while(!inp.toUpperCase().equals("EXIT")){                                    // Loop body executes until user requests to stop (by entering exit)

            // COMMAND 1 - "help" - Prints instructions if user requests for help.
            if(inp.equals("help")){
                printing("\n" + "Possible commands are as follows:" + "\n" +                       // PRINTING METHOD takes a string, prints it along with request for next input from the user.
                        "create location [fast][flexible]: Creates a new piece." + "\n" +
                        "move location direction [spaces]: Moves a piece." + "\n" +
                        "print: Displays the board." + "\n" +
                        "help: Displays help." + "\n" +
                        "exit: Exits the program.");
                continue;                                                                  // Continues the game with next requests
            }

            // COMMAND 2 - "print" - Displays the game board.
            if(inp.equals("print")){

                b.displayBoard();
                System.out.println("\n" + "Enter a command (type help for details):");
                inp = kb.nextLine();
                continue;
            }

            // COMMAND 3 - "create.." - Creating a new piece as requested by user specifications........................................................................................
            if(inp.startsWith("create")){

                String[] inp_split = inp.split(" ");                          // Splitting the input by user to create a piece at the asked position and specification
                int x = 0,y = 0;

                // This section checks if either of X or both X and Y positions are entered invalid.
                if(!piece.setX(inp_split[1])){
                    if (inp_split.length > 2){
                        if (!piece.setY(inp_split[2])) {
                            printing("Enter a valid X and Y position." + "\n");
                            continue;
                        }
                        else{
                            printing("Enter a valid X position." + "\n");
                            continue;
                        }
                    }
                    else {
                        printing("Enter a valid X position." + "\n");
                        continue;
                    }
                }
                else {
                    x = Integer.parseInt(inp_split[1]);
                    piece.setX(inp_split[1]);
                }
                // Checks if invalid Y position is entered.
                if(inp_split.length > 2) {
                    if (!piece.setY(inp_split[2])) {
                        printing("Enter a valid Y position." + "\n");
                        continue;
                    }
                    else {
                        y = Integer.parseInt(inp_split[2]);
                        piece.setY(inp_split[2]);
                    }
                }


                // Takes inputs of name and colour of piece.
                System.out.println("\n" + "Input a name for the new piece:");
                String pName = kb.nextLine();

                System.out.println("Input a colour for the new piece:");
                String pColour = kb.nextLine();

                String info = "";                           // Stores piece name/colour and type

                // Checks the character of piece and sets their name, colour and toString accordingly.
                if(inp_split.length < 4){                                                            // By default a piece is Slow if not mentioned (Then, input size will be less than 4)
                    slowP.setName(pName);
                    slowP.setColour(pColour);

                    info = slowP.toString();

                }
                else if(inp_split.length == 4){                                                      // If piece type is mentioned its information is added to the board
                    if(inp_split[3].equals("fast")){
                        fastP.setName(pName);
                        fastP.setColour(pColour);
                        info = fastP.toString();
//                        info = pName + pColour + "Fast".charAt(0);
                    }
                    else if(inp_split[3].equals("slow")){
                        slowP.setName(pName);
                        slowP.setColour(pColour);

                        info = slowP.toString();
                    }
                    else if(inp_split[3].equals("flexible")){
                        slowflexP.setName(pName);
                        slowflexP.setColour(pColour);
                        info = slowflexP.toString();
                    }
                    else{
                        printing("Enter a valid character of piece. Type help for more information.");
                        continue;
                    }
                }
                else if(inp_split.length > 4 && inp_split[3].equals("slow") && inp_split[4].equals("flexible")){                                // if inp_split.length > 4, more info is mentioned
                    slowflexP.setName(pName);
                    slowflexP.setColour(pColour);
                    info = slowflexP.toString();
                }
                else if(inp_split.length > 4 && inp_split[3].equals("fast") && inp_split[4].equals("flexible")){
                    fastflexP.setName(pName);
                    fastflexP.setColour(pColour);
                    info = fastflexP.toString();
                }
                else{
                    printing("Enter a valid character of piece. Type help for more information.");
                    continue;
                }

                //System.out.println("info " + info + " x,y" + x + y);
                if(!b.addPiece(info, x, y)){                                        // Checks if the position where piece is to be added is empty
                    System.out.println("Piece not added - Add it in an empty position.");
                }
                else {
                    b.addPiece(info, x, y);                                        // Adds the piece made to requested position
                    System.out.println("Created new game piece." + "\n");
                }

                System.out.println("\n" + "Enter a command (type help for details):");
                inp = kb.nextLine();
                continue;

            }

            //COMMAND 4 - "move.." - Moving the existing piece to requested position by the user.......................................................................................
            if(inp.startsWith("move")){
                String[] inp_split = inp.split(" ");                          // Splitting the input by user to create a piece at the asked position and specification
                int x = 0,y = 0;

                // This section checks if either X or both X and Y positions are invalid.
                if(!piece.setX(inp_split[1])){
                    if (inp_split.length > 2){
                        if (!piece.setY(inp_split[2])) {
                            printing("Enter a valid X and Y position." + "\n");
                            continue;
                        }
                        else{
                            printing("Enter a valid X position." + "\n");
                            continue;
                        }
                    }
                    else {
                        printing("Enter a valid X position." + "\n");
                        continue;
                    }
                }
                else {
                    x = Integer.parseInt(inp_split[1]);
                    piece.setX(inp_split[1]);
                }
                // Checks if invalid Y position is entered.
                if (inp_split.length > 2) {
                    if (!piece.setY(inp_split[2])) {
                        printing("Enter a valid Y position." + "\n");
                        continue;
                    } else {
                        y = Integer.parseInt(inp_split[2]);
                        piece.setY(inp_split[2]);
                    }
                }

                // Checks if valid number/integer of spaces to be moved are entered if any.
                int spaces = 0;
                if(inp_split.length == 5){
                    if("0123456789".contains(inp_split[4])){
                        spaces = Integer.parseInt(inp_split[4]);
                    }
                    else {
                        printing("Enter valid number of spaces to move the piece.");
                    }
                }

                String pInfo;                               // pInfo will hold the player name, colour, character

                if (b.getInfo(x, y).equals("-")) {                                              // Checks if an empty position is asked to be moved.
                        printing("Nothing to move, that position is empty.");
                    continue;
                }
                else {
                    pInfo = b.getInfo(x, y);
                }

                // Initializing variables for the following move conditions.
                int len = pInfo.length();
                String direction = inp_split[3];
                String character ;
                int newX, newY ;

                // When input size is less than 5, by default spaces = 1 (since space was not mentioned in input)
                if(inp_split.length < 5){
                    spaces = 1;

                    // When piece is SLOW FLEXIBLE piece
                    if(pInfo.charAt(len-2) == 'S' && pInfo.charAt(len-1) == 'F'){
                        if(slowflexP.move(direction, x, y) == -1){                                                      // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(slowflexP.move(direction, x, y) == -2){                                                 // Checks if correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else{
                            if(direction.equals("left") || direction.equals("right")){
                                newY = slowflexP.move(direction, x, y);
                                if(!b.movePiece(x, newY, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(x, newY, x, y, pInfo);                                                  // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                            if(direction.equals("up") || direction.equals("down")){
                                newX = slowflexP.move(direction, x, y);

                                if(!b.movePiece(newX, y, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {                                                                                  // Moves the piece, prints how far it was moved
                                    b.movePiece(newX, y, x, y, pInfo);
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                        }
                    }
                    // When piece is FAST FLEXIBLE
                    else if(pInfo.charAt(len-2) == 'F' && pInfo.charAt(len-1) == 'F'){
                        if(fastflexP.move(direction, x, y, spaces) == -1){                                              // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(fastflexP.move(direction, x, y, spaces) == -2){                                         // Checks if correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else{
                            if(direction.equals("left") || direction.equals("right")){
                                newY = fastflexP.move(direction, x, y, spaces);
                                if(!b.movePiece(x, newY, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(x, newY, x, y, pInfo);                                                  // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                            if(direction.equals("up") || direction.equals("down")){
                                newX = fastflexP.move(direction, x, y, spaces);
                                if(!b.movePiece(newX, y, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(newX, y, x, y, pInfo);                                                  // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                        }
                    }
                    // When piece is a SLOW piece
                    else if (pInfo.charAt(pInfo.length() - 1) == 'S') {
                        if(slowP.move(direction, x, y) == -1){                                                          // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(slowP.move(direction, x, y) == -2){                                                     // Checks if correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else {
                            newY = slowP.move(direction, x, y);
                            if(!b.movePiece(x, newY, x, y, pInfo )){                                                    // Checks if the new position where the piece is to be moved is empty
                                printing("Move not complete. Move it to an empty position.");
                                continue;
                            }
                            else {
                                b.movePiece(x, newY, x, y, pInfo );                                                     // Moves the piece, prints how far it was moved
                                printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                continue;
                            }
                        }
                    }
                    // When piece is a FAST piece
                    else if(pInfo.charAt(len-1) == 'F'){
                        spaces = 1;
                        if(fastP.move(direction, x, y, spaces) == -1){                                                  // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(fastP.move(direction, x, y, spaces) == -2){                                             // Checks correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else{
                            newY = fastP.move(direction, x, y, spaces);
                            if(!b.movePiece(x, newY, x, y, pInfo)){                                                     // Checks if the new position where the piece is to be moved is empty
                                printing("Move not complete. Move it to an empty position.");
                                continue;
                            }
                            else {
                                b.movePiece(x, newY, x, y, pInfo);                                                      // Moves the piece, prints how far it was moved
                                printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                continue;
                            }
                        }
                    }
                }

                // If input size = 5, move spaces are mentioned in the input (For slow pieces by default spaces = 1)
                else if(inp_split.length == 5){

                    // When piece is SLOW FLEXIBLE piece
                    if(pInfo.charAt(len-2) == 'S' && pInfo.charAt(len-1) == 'F'){
                        if(slowflexP.move(direction, x, y) == -1){                                                      // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(slowflexP.move(direction, x, y) == -2){                                                 // Checks correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else if( spaces != 1){                      // If input requests to move a slow piece by more than one space
                            printing("Slow flexible piece can\'t move " + spaces + " spaces.");
                            continue;
                        }
                        else{
                            if(direction.equals("left") || direction.equals("right")){
                                newY = slowflexP.move(direction, x, y);
                                if(!b.movePiece(x, newY, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(x, newY, x, y, pInfo);                                                  // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                            if(direction.equals("up") || direction.equals("down")){
                                newX = slowflexP.move(direction, x, y);
                                if(!b.movePiece(newX, y, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(newX, y, x, y, pInfo);                                                  // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                        }
                    }
                    // When piece is FAST FLEXIBLE
                    else if(pInfo.charAt(len-2) == 'F' && pInfo.charAt(len-1) == 'F'){
                        if(fastflexP.move(direction, x, y, spaces) == -1){                                              // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(fastflexP.move(direction, x, y, spaces) == -2){                                         // Checks if correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else{
                            if(direction.equals("left") || direction.equals("right")){
                                newY = fastflexP.move(direction, x, y, spaces);
                                if(!b.movePiece(x, newY, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(x, newY, x, y, pInfo);                                                  // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                            if(direction.equals("up") || direction.equals("down")){
                                newX = fastflexP.move(direction, x, y, spaces);
                                if(!b.movePiece(newX, y, x, y, pInfo)){                                                 // Checks if the new position where the piece is to be moved is empty
                                    printing("Move not complete. Move it to an empty position.");
                                    continue;
                                }
                                else {
                                    b.movePiece(newX, y, x, y, pInfo);                                      // Moves the piece, prints how far it was moved
                                    printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                    continue;
                                }
                            }
                        }
                    }
                    // When piece is SLOW piece
                    else if(pInfo.charAt(len-1) == 'S'){
                        if(slowP.move(direction, x, y) == -1){                                                          // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(slowP.move(direction, x, y) == -2){                                                     // Checks if correct direction for the particular type has been requested
                            printing("Move not complete. Enter a valid direction.");
                            continue;
                        }
                        else if( spaces != 1){                      // If input requests to move a slow piece by more than one space
                            printing("Slow piece can\'t move " + spaces + " spaces.");
                            continue;
                        }
                        else {
                            newY = slowP.move(direction, x, y);
                            if(!b.movePiece(x, newY, x, y, pInfo)){                                                     // Checks if the new position where the piece is to be moved is empty
                                printing("Move not complete. Move it to an empty position.");
                                continue;
                            }
                            else {
                                b.movePiece(x, newY, x, y, pInfo);                                          // Moves the piece, prints how far it was moved
                                printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                continue;
                            }
                        }
                    }
                    // When piece is FAST piece
                    else if(pInfo.charAt(len-1) == 'F'){
                        if(fastP.move(direction, x, y, spaces) == -1){                                      // Checks if the move is legal
                            printing("Move not complete. Move it to valid position.");
                            continue;
                        }
                        else if(fastP.move(direction, x, y, spaces) == -2){
                            printing("Move not complete. Enter a valid direction.");                     // Checks if correct direction for the particular type has been requested
                            continue;
                        }
                        else{
                            newY = fastP.move(direction, x, y, spaces);
                            if(!b.movePiece(x, newY, x, y, pInfo)){                                         // Checks if the new position where the piece is to be moved is empty
                                printing("Move not complete. Move it to an empty position.");
                                continue;
                            }
                            else {
                                b.movePiece(x, newY, x, y, pInfo);                                          // Moves the piece, prints how far it was moved
                                printing("Piece at " + x + ", " + y + " moved " + direction + " by " + spaces + " space.");
                                continue;
                            }
                        }
                    }
                }


                System.out.println("\n" + "Enter a command (type help for details):");             // Input for next command
                inp = kb.nextLine();
                continue;

            }          // END of MOVE command


           else{                                            // If any command other than mentioned above is entered.
                System.out.println("Invalid Command.");
            }
            System.out.println("\n" + "Enter a command (type help for details):");
            inp = kb.nextLine();

        }            // END of main loop body

        System.out.println("\n" + "Done.");

    }                // END of main method

    // Printing method takes a string, prints it along with request for next input from the user. This has been used in the main method several times.
    public static void printing(String a){
            System.out.println(a + "\n");
            System.out.println("\n" + "Enter a command (type help for details):");
            inp = kb.nextLine();
    }
} // END of GameDemo.java CLASS