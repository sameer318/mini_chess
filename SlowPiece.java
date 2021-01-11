public class SlowPiece extends Piece{

    public SlowPiece(){             // Creating constructor
    }

    public SlowPiece(String name, String colour, int xpos, int ypos){
        super(name, colour, xpos, ypos);
    }

    public int move(String direction, int x, int y){             // Move method moves piece one step to the right or to the left

        if(direction.equals("left") && y!=0){               // Ensuring the piece is not going off the board
            y -=1;
            return y;
        }
        else if(direction.equals("right") && y!=7){
            y+=1;
            return y;
        }
        else if(!direction.equals("left") && !direction.equals("right") && !direction.equals("up") && !direction.equals("down")){
            return -2;              // if non of the valid directions are entered returns -2
        }
        else return -1;
    }

    public String toString(){
        return super.toString() + "S";
    }           // Returns toString for slow piece
}