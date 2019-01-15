package chess;
//@author Gustavo Targino

public class King extends Piece {
    
    public King(String nick, int color) {
        super (nick, color);
    }
    
    public boolean movement () {
        return true;
    }
}