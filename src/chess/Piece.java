package chess;
// @author Gustavo Targino
public class Piece {

    public Piece(int color, int[][] piecePosition) {
        this.color = color; // 0-white 1-Black
        this.piecePosition = piecePosition;
    }
    
    int color;
    int[][] piecePosition;
    
    public int getColor() {
        return this.color;
    }
    
    public int[][] getPiecePosition() {
        return this.piecePosition;
    }
    
    public void setPiecePosition(int[][] pp) {
        this.piecePosition = pp;
    }
    
}
