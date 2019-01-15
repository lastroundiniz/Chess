package chess;
// @author Gustavo Targino

public class Piece {
    int color;
    String nick = new String();
    
    
    public Piece(String nick, int color) {
        this.color = color; // 0-white 1-Black
        this.nick = nick;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getNick() {
        return this.nick;
    }
}
