package chess;
//@author Gustavo Targino

public class Pawn extends Piece {
   boolean firstStep = false;
    public Pawn(String nick, int color) {
        super (nick, color);
    } 
    
    @Override
    public boolean pieceMovement (int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
        boolean moved = false;
        
        if (this.color == 0) { // 0-white 1-black 
            if ((targetRow - sourceRow) == 1)
                moved = true;
            else if ((targetRow - sourceRow) == 2 && !firstStep)
                firstStep = true;
                moved = true;
        } else {
            if ((targetRow - sourceRow) == -1)
                moved = true;
            else if ((targetRow - sourceRow) == -2 && !firstStep)
                firstStep = true;
                moved = true;
        }
        return moved;
        
    }
}