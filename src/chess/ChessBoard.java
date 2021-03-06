package chess;
// @author Gustavo Targino

public class ChessBoard {
    Piece [][] board = new Piece[8][8];
    
    King whiteKing = new King("K_W",0);
    King blackKing = new King("K_B",1);
    
    Pawn whitePawn0 = new Pawn("P_W",0);
    Pawn whitePawn1 = new Pawn("P_W",0);
    Pawn whitePawn2 = new Pawn("P_W",0);
    Pawn whitePawn3 = new Pawn("P_W",0);
    Pawn whitePawn4 = new Pawn("P_W",0);
    Pawn whitePawn5 = new Pawn("P_W",0);
    Pawn whitePawn6 = new Pawn("P_W",0);
    Pawn whitePawn7 = new Pawn("P_W",0);
    
    Pawn blackPawn0 = new Pawn("P_B",1);
    Pawn blackPawn1 = new Pawn("P_B",1);
    Pawn blackPawn2 = new Pawn("P_B",1);
    Pawn blackPawn3 = new Pawn("P_B",1);
    Pawn blackPawn4 = new Pawn("P_B",1);
    Pawn blackPawn5 = new Pawn("P_B",1);
    Pawn blackPawn7 = new Pawn("P_B",1);
    Pawn blackPawn6 = new Pawn("P_B",1);
    
    String alphaColumns[] = {"A","B","C","D","E","F","G","H"};
    
    public void setStandardScheme() {
        // standard position of all pieces
        
        // white
        board [7][4] = whiteKing;
        board [6][0] = whitePawn0;
        board [6][1] = whitePawn1;
        board [6][2] = whitePawn2;
        board [6][3] = whitePawn3;
        //board [6][4] = whitePawn4;
        board [6][5] = whitePawn5;
        board [6][6] = whitePawn6;
        board [6][7] = whitePawn7;
        
        // black
        board [0][4] = blackKing;
        board [1][0] = blackPawn0;
        board [1][1] = blackPawn1;
        board [1][2] = blackPawn2;
        board [1][3] = blackPawn3;
        board [1][4] = blackPawn4;
        board [1][5] = blackPawn5;
        board [1][6] = blackPawn6;
        board [1][7] = blackPawn7;
    }
    
  
    public boolean setPieceSquare(String source, String destination) {
        // inicalization
        String strSourceRow, strSourceColumn, strTargetRow, strTargetColumn;
        int sourceRow, sourceColumn, targetColumn, targetRow;
        
        // declaration
        boolean moved = false, inputCaught = false;
        sourceRow = targetRow = sourceColumn = targetColumn = -1;
        
        // try/catch statement cuz we never understand the player's mind
        try {
            // spliting n saving source and destination columns/rows
            strSourceRow = source.substring(1); 
            strSourceColumn = source.substring(0,1).toUpperCase(); 
            strTargetRow = destination.substring(1);
            strTargetColumn = destination.substring(0,1).toUpperCase();
            
            // converting source and destination columns strings to int
            // take the index from a list containing the alphabet from A to H
            for (int i = 0; i < alphaColumns.length; i++) {
                if (alphaColumns[i].equals(strSourceColumn))
                    sourceColumn = i;
                if (alphaColumns[i].equals(strTargetColumn))
                    targetColumn = i;
            }
         
            // converting source and destination rows strings to int
            // player sees a 1-8 range, but we know how things really are. That's why -1.
            sourceRow = (Integer.parseInt(strSourceRow)) - 1;
            targetRow = (Integer.parseInt(strTargetRow)) - 1;
            
            inputCaught = true;
        } catch (Exception e) {
            // e.printStackTrace(); // log stack trace error
            System.out.println("Invalid input. Please, attempt for the input format required");
        }
        
        // succeeded in picking input?
        if (inputCaught) {
            // player enter an inverted row when inputs the square target, let's decode this
            
            // if input is 7, on the matrix mean 0; input 6, matrix 1; input 5,
            // matrix 2; input 4, matrix 3; input 3, matrix 4; 2, 5; 1, 6; 0, 7;
            
            // i of invertedMatrix; r of realMatrix
            for (int i = 0, r = board.length-1; i <= board.length - 1; i++, r--) {
                if (sourceRow == i) {
                    sourceRow = r;
                    break;
                }
            }
            
            // i of invertedMatrix; r of realMatrix
            for (int i = 0, r = board.length-1; i <= board.length - 1; i++, r--) {
                if (targetRow == i) {
                    targetRow = r;
                    break;
                }
            }
            
            // checking if the source and target square are valid
            // inside X n Y limits? - source is different of target? - source isn't empty? So, ok.
            if (sourceRow < board.length && sourceColumn < board[0].length &&
		targetRow < board.length && targetColumn < board[0].length && 
                sourceRow >= 0 && sourceColumn >= 0 && targetRow >= 0 && targetColumn >= 0 && 
                (sourceColumn != targetColumn || sourceRow != targetRow) && 
                board[sourceRow][sourceColumn] != null) {
                
                // check if the target square is available or there is a same color piece in the target square
                if (board[targetRow][targetColumn] == null ||
                        !(board[sourceRow][sourceColumn].getColor() == board[targetRow][targetColumn].getColor())) {
                    // try to do the piece movement
                    moved = board[sourceRow][sourceColumn].pieceMovement(sourceRow, sourceColumn, targetRow, targetColumn, this);
                    if (moved) {
                            board[targetRow][targetColumn] = board[sourceRow][sourceColumn];
                            board[sourceRow][sourceColumn] = null;
                    }
                } else {
                    System.out.println("Square is filled with a same color piece");
                }
            } else {
                System.out.println("Invalid movement. Source is empty OR the source"
                        + " and target are the same OR source and target does not exist ");
            }
        }
        return moved;
    }
    public void getPieceInPosition(int row, int column) {
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
    public boolean hasPawnToPromote () {
        boolean hasPawn = false;
        for (int i = 0; i < board[7].length; i++) {
            System.out.println("black " + board[7][i]);
            if (board[7][i] != null) {
                if (board[7][i].getNick().equals("P_B"))
                    hasPawn = true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            System.out.println("white " + board[0][i]);
            if (board[0][i] != null) {
                if (board[0][i].getNick().equals("P_W"))
                    hasPawn = true;
            }
        }
        return hasPawn;
    }
}