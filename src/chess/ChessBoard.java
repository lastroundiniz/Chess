package chess;
// @author Gustavo Targino

// Bishop, King, Queen, Rook, Pawn, Knight

public class ChessBoard {
    Piece [][] board = new Piece[8][8];
    King whiteKing = new King("K_W",0);
    King blackKing = new King("K_B",1);
    
    String alphaColuns[] = {"A","B","C","D","E","F","G","H"};
    
    public void setStandardScheme() {
        // standard position of all pieces
        
        // white
        board [0][4] = whiteKing;
        
        // black
        board [7][4] = blackKing;
    }
    
    
    public void setPiecePosition(int sourceRow, int sourceColun,
            int targetRow, int targetColun) {
        getPieceInPosition(sourceRow, sourceColun);
        
        if (targetRow > board.length || targetColun > board[0].length)
            System.out.println("Invalid movement, the target does not exist");
        
    }
    
    public void getPieceInPosition(int row, int colun) {
        //return board [7][4]
    }
    
    public void printBoard() {
        for (int row = 0; row < board.length; row ++) {
            System.out.print(" |" + alphaColuns[row] + "| ");
            for (int col = 0; col < board[0].length; col ++) {
                if (col == 0)
                    System.out.println();
                // if we have some piece on the position, print it! Else, 
                if (board[row][col] != null)
                    System.out.print("| " + board[row][col].getNick() + " ");
                else
                    System.out.print( "|  X  ");
            }
            System.out.println("");
        }
    }
}