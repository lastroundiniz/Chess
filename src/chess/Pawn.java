package chess;
//@author Gustavo Targino

public class Pawn extends Piece {

    boolean firstStepDone = false;
    public Pawn(String nick, int color) {
        super (nick, color);
    }
    
    public boolean checkIfPathIsClear (int sourceRow, int targetRow, int sourceColumn, ChessBoard cb) {
        boolean clear = false;
        
        if (this.color == 0) { // 0-white 1-black
            for (int i = sourceRow - 1; i >= targetRow; i--) {
                if (cb.board[i][sourceColumn] == null)
                    clear = true;
            }
        } else {
            for (int i = sourceRow + 1; i <= targetRow; i++) {
                if (cb.board[i][sourceColumn] == null)
                    clear = true;
            }
        }
        return clear;
    }
       
    @Override
    public boolean pieceMovement (int sourceRow, int sourceColumn, int targetRow, int targetColumn, ChessBoard cb) {
        boolean moved = false;
        
        // the pawn is moving to a column of the same origin? 
        if (targetColumn == sourceColumn) {
            // path must be empty
            if (checkIfPathIsClear(sourceRow,targetRow,sourceColumn,cb)) {
                if (this.color == 0) { // 0-white 1-black
                    if ((targetRow - sourceRow) == -1) {
                        this.firstStepDone = true;
                        moved = true;
                    }
                    else if ((targetRow - sourceRow) == -2 && !this.firstStepDone) {
                        this.firstStepDone = true;
                        moved = true;
                    }
                    else {
                        System.out.println("Pawn can't do this movement");
                    }
                } else {
                    if ((targetRow - sourceRow) == 1) {
                        this.firstStepDone = true;
                        moved = true;
                    }
                    else if ((targetRow - sourceRow) == 2 && !this.firstStepDone) {
                        this.firstStepDone = true;
                        moved = true;
                    }
                    else {
                        System.out.println("Pawn can't do this movement");
                    }
                }
            } else {
                System.out.println("Pawn can't do this movement");
            }
        // capturing. target cant be null
        } else if (Math.abs(targetColumn - sourceColumn) == 1 && cb.board[targetRow][targetColumn] != null) {
            if (this.color == 0) { // 0-white 1-black
                if ((targetRow - sourceRow) == -1) {
                    this.firstStepDone = true;
                    moved = true;
                }
                else {
                    System.out.println("Pawn can't do this movement");
                }
            } else {
                if ((targetRow - sourceRow) == 1) {
                    this.firstStepDone = true;
                    moved = true; 
                }
                else {
                    System.out.println("Pawn can't do this movement");
                }
            } 
        } else {
            System.out.println("Pawn can't do this movement");
        }
        return moved;
    }
}