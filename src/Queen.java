
public class Queen extends Piece {

	public String piece_type = "q";
	
	private char piece_color;
	
	
	public Queen(char piece_color) {
		this.piece_color = piece_color;
	}
	
	public void movePiece() {
		return;
	}

	public String get_type() {
		return this.piece_type;
	}
	
	public char get_color() {
		return this.piece_color;
	}
	
	public String display_piece() {
		return this.piece_color + piece_type;
	}
	
	
	
	
	
}