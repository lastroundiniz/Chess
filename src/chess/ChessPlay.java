package chess;
// @author Gustavo Targino

public class ChessPlay {
    
    public static void main(String[] args) {
        ChessBoard cb = new ChessBoard();
        cb.setStandardScheme();
        cb.printBoard();
        
        System.out.println(" ");
        System.out.println("white turn");
        
        System.out.println("Choose a piece to move");
        System.out.println("Firt enter the source coordinates (e.g A4) where"
                + " the peace you want to move is");
        System.out.println("Then enter the destination coordinates (e.g A5)");
    }
}
