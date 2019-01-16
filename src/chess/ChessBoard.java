package chess;
// @author Gustavo Targino

// Bishop, King, Queen, Rook, Pawn, Knight

public class ChessBoard {
    Piece [][] board = new Piece[8][8];
    King whiteKing = new King("K_W",0);
    King blackKing = new King("K_B",1);
    
    String alphaColumns[] = {"A","B","C","D","E","F","G","H"};
    
    public void setStandardScheme() {
        // standard position of all pieces
        
        // white
        board [7][4] = whiteKing;
        
        // black
        board [0][4] = blackKing;
    }
            
    public boolean setPieceSquare(String source, String destination) {
        String strSourceRow, strSourceColumn, strTargetRow, strTargetColumn;
        int sourceRow, sourceColumn, targetColumn, targetRow;
        boolean moved = false;
        int diference = 7;
        
        // spliting n saving source and destination columns/rows
        strSourceRow = source.substring(1); 
        strSourceColumn = source.substring(0,1).toUpperCase(); 
        strTargetRow = destination.substring(1);
        strTargetColumn = destination.substring(0,1).toUpperCase();    
        
        // converting source and destination columns strings to int
        sourceColumn = targetColumn = 0;
        for (int i = 0; i < alphaColumns.length; i++) {
            if (alphaColumns[i].equals(strSourceColumn))
                sourceColumn = i;
            if (alphaColumns[i].equals(strTargetColumn))
                targetColumn = i;
        }
         
        // converting source and destination rows strings to int
        sourceRow = (Integer.parseInt(strSourceRow)) - 1;
        targetRow = (Integer.parseInt(strTargetRow)) - 1;
        
        // player enter a inverted row when inputs the square target
        // this function tries to forcefully decode this (better find something cleaner)
        if (sourceRow == 0)
            sourceRow = 7;
        else if (sourceRow == 1)
            sourceRow = 6;
        else if (sourceRow == 2)
            sourceRow = 5;
        else if (sourceRow == 3)
            sourceRow = 4;
        else if (sourceRow == 4)
            sourceRow = 3;
        else if (sourceRow == 5)
            sourceRow = 2;
        else if (sourceRow == 6)
            sourceRow = 1;
        else if (sourceRow == 7)
            sourceRow = 0;
       
        if (targetRow == 0)
            targetRow = 7;
        else if (targetRow == 1)
            targetRow = 6;
        else if (targetRow == 2)
            targetRow = 5;
        else if (targetRow == 3)
            targetRow = 4;
        else if (targetRow == 4)
            targetRow = 3;
        else if (targetRow == 5)
            targetRow = 2;
        else if (targetRow == 6)
            targetRow = 1;
        else if (targetRow == 7)
            targetRow = 0;
                
        System.out.println("sourceRow: " + sourceRow + " sourceColumn: " + sourceColumn);
        System.out.println("targetRow: " + targetRow + " targetColumn: " + targetColumn);
        
        // checking if the source and target square are valid
        if (sourceRow <= board.length && sourceColumn <= board[0].length &&
                targetRow <= board.length && targetColumn <= board[0].length) {
            // check if the target square is available
            if (board[targetRow][targetColumn] == null) {
                // do the piece movement
                System.out.println("moved");
                moved = true;
                board[targetRow][targetColumn] = board[sourceRow][sourceColumn];
                board[sourceRow][sourceColumn] = null;
                return moved;
            } else {
                // checking if there is a same color piece in the target square
                if (board[sourceRow][sourceColumn].getColor() == board[targetRow][targetColumn].getColor()) {
                    System.out.println("Square is fill with a same color piece");
                    return moved;
                } else {
                    System.out.println("moved");
                    moved = true;
                    board[targetRow][targetColumn] = board[sourceRow][sourceColumn];
                    board[sourceRow][sourceColumn] = null;
                    return moved;
                }
            }
        } else {
            System.out.println("Invalid movement, the target does not exist");
            return moved;
        }
    }
    
    public void getPieceInPosition(int row, int Column) {
        //return board [7][4]
    }
    
    public void printBoard() {
        System.out.print("     ");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print("   " + alphaColumns[i] + "  ");
        }
        System.out.println("");
        System.out.println("     -------------------------------------------------");
        for (int row = 0, boardNum = board.length; row < board.length; row ++, boardNum--) {
            System.out.print("  " + boardNum + "  ");
            for (int col = 0; col < board[0].length; col ++) {
                // if have some piece in the position, print it. Else, not.
                if (board[row][col] != null)
                    System.out.print("| " + board[row][col].getNick() + " ");
                else
                    System.out.print( "|  .  ");
                if (col == 7)
                    System.out.print("| " + boardNum + "  ");
            }
            System.out.println("");
            System.out.println("     -------------------------------------------------");
        }
        System.out.print("     ");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print("   " + alphaColumns[i] + "  ");
        }
        System.out.println(" ");
    }
}