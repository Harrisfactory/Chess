
public class Pawn extends Piece {

	public String piece_type = "p";
	
	private char piece_color;
	
	public Pawn(char piece_color) {
		this.piece_color = piece_color;
	}
	
	public void movePawn() {
		System.out.print("pawn moved");
		return;
	}

	public String get_type() { return this.piece_type; }
	
	public char get_color() {
		return this.piece_color;
	}
	
	public String display_piece() {
		return this.piece_color + piece_type;
	}

	
	
	
	
	
}
