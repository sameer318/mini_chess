public class Board {
    private String[][] board = new String[8][8];                 // Creating a 2D array as board

    public Board(){                                              // Constructor
    }

    public void displayBoard(){      // Method to display board

        fill();                                                 // Fill method created to fill the board with "-" wherever it has null positions.

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].equals("-")){
                    System.out.print(board[i][j] + "\t \t \t" );
                }
                else System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }    // End of display board method

    public boolean addPiece(String info, int x, int y){            // Adds a piece to the board at a location, if that location is empty

        fill();                                                    // Fills the board with "-"

        if(board[x][y].equals("-")){
            board[x][y] = info ;
            fill();
            return true;
        }
        else return false;
    }    // End of add piece method

    public boolean movePiece(int newX, int newY, int x, int y, String info){            // Moves a piece to a new position and adds "-" to its previous positon
        fill();
        if(board[newX][newY].equals("-")){
            board[newX][newY] = info ;
            board[x][y] = "-";
            return true;
        }
        else return false;

    }   // End of move piece method


    public String getInfo(int x, int y){                        // Get info returns the toString of piece (Name, Colour, Type) that was previously added to the board
        fill();
        String info = board[x][y];
        return info;
    }   // End of Get Info

    public void fill(){
        for(int i = 0; i < 8; i++){                   // enters "-" to null spaces in the game board
            for(int j = 0; j < 8; j++){
                if(board[i][j] == null){
                    board[i][j] = "-";
                }
            }
        }
    }    // End of fill() method


} // End of Board class