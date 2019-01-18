package chess;
import java.util.Scanner;
// @author Gustavo Targino

public class ChessPlay {
    
    public static void main(String[] args) {
        ChessBoard cb = new ChessBoard();
        cb.setStandardScheme();
        cb.printBoard();
        
        Scanner input = new Scanner(System.in);
        String source, destination;
        
        while (true) {
            System.out.println(" ");

            System.out.println("Enter the source coordinates (e.g A4) where"
                    + " the peace you want to move is");
            source = input.next();
            System.out.println("Then enter the destination coordinates (e.g A5)");
            destination = input.next();

            System.out.println(cb.setPieceSquare(source, destination));

            cb.printBoard();
        }
    }
}
