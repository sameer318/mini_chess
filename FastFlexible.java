public class FastFlexible extends FastPiece {

    public FastFlexible(){                     // Creating constructor
    }

    public FastFlexible(String name, String colour, int xpos, int ypos){
        super(name, colour, xpos, ypos);
    }

    public int move(String direction, int x, int y, int n){              // Move method moves the piece to left or right by n number of spaces

        if(direction.equals("left") && y!=0 && y - n >= 0 ){             // Ensuring the piece is not going off the board
            y-=n;
            return y;
        }
        else if(direction.equals("right") && y!=7 && y + n <= 7){
            y+=n;
            return y;
        }
        else if(direction.equals("up") && x!=0 && x - n >= 0){
            x-=n;
            return x;
        }
        else if(direction.equals("down") && x!=7 && x + n <= 7){
            x+=n;
            return x;
        }
        else if(!direction.equals("left") && !direction.equals("right") && !direction.equals("up") && !direction.equals("down")){
            return -2;           // if non of the valid directions are entered returns -2
        }
        else return -1;
    }

    public String toString(){
        return super.toString() + "F";
    }     // Returns toString for fast flexible piece
}
