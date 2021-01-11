public class Piece {
    protected String name;              // Variables for piece
    protected String colour;
    protected int xpos, ypos;

    public Piece(){                     // Constructor
    }

    public Piece(String name, String colour, int xpos, int ypos){
        this.name = name;
        this.colour = colour;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    // Set Methods
    public void setName(String name){
        this.name = name;
    }
    public void setColour(String colour){
        this.colour = colour;
    }

    // This method makes sure right values of x are set. "0-7 due to the size of the board".
    public boolean setX(String inp){          // WAS SIMPLE SET X { THIS.XPOS = XPOS}

        if("01234567".contains(inp)){
            this.xpos = Integer.parseInt(inp);
            return true;
        }
        else return false;
    }

    // This method makes sure right values of y are set. "0-7 due to the size of the board".
    public boolean setY(String inp){          // WAS SIMPLE SET Y { THIS.XPOS = XPOS}

        if("01234567".contains(inp)){
            this.ypos = Integer.parseInt(inp);
            return true;
        }
        else return false;
    }

    // Get methods
    public String getName(){
        return name;
    }
    public String getColour(){
        return colour;
    }
    public int getX(){
        return xpos;
    }
    public int getY(){
        return ypos;
    }

    public String toString(){
        return name + colour ;
    }    // Returns toString for name and colour of piece
}
