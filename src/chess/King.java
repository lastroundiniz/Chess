package chess;
// @author Gustavo Targino

public class King extends Piece {
    
    public King(String nick, int color) {
        super (nick, color);
    }
    
    @Override
    public boolean pieceMovement (int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
        if (Math.abs(sourceRow - targetRow) == 1 && Math.abs(sourceColumn - targetColumn) == 1 ||
                Math.abs(sourceRow - targetRow) == 1 && Math.abs(sourceColumn - targetColumn) == 0 ||
                Math.abs(sourceRow - targetRow) == 0 && Math.abs(sourceColumn - targetColumn) == 1)
            return true;
        else {
            System.out.println("King can't do this movement");
            return false;
        }
            
    }
}