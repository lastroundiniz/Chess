package chess;
// @author Gustavo Targino

// Bishop, Pawn, Queen, Rook, Pawn, Knight
public class Piece {
    int color;
    String nick = new String();
    
    
    public Piece(String nick, int color) {
        this.color = color; // 0-white 1-black
        this.nick = nick;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getNick() {
        return this.nick;
    }
    
    public boolean pieceMovement (int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
        return false;
    }
}
