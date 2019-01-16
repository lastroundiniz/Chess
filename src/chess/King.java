package chess;
//@author Gustavo Targino

public class King extends Piece {
    
    public King(String nick, int color) {
        super (nick, color);
    }
    
    public boolean movement (int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
        return true;
    }
}