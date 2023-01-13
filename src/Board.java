
public class Board {

	private Piece[][] board = new Piece[8][8];
		
	
	public Board() {
		
		
	}
	
	public void add_piece(Piece piece, int position_x, int position_y) {
		this.board[position_x][position_y] = piece;
	}
	
	public void display_board() {
		System.out.println();
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(isPiece(x,y)) {
					System.out.print('|' + this.board[x][y].display_piece() + '|');
				} else {
					System.out.print("|  |");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean isPiece(int position_x, int position_y) {
		if(board[position_x][position_y] != null)
			return true;
		return false;
	}
	
	
	public void movePiece(int old_position_x, int old_position_y, int new_position_x, int new_position_y) {

		//get piece
		//TODO if exists
		Piece piece = board[old_position_x][old_position_y];
		System.out.print(piece.get_type());
		//TODO check legal
		if(piece.get_type() == "p")
			checkPawnMoveLegal(piece, old_position_x, old_position_y,  new_position_x, new_position_y);

		//moves piece
		this.board[new_position_x][new_position_y] = piece;
		this.board[old_position_x][old_position_y] = null;
	}
	
	public boolean checkTurnToPiece(char current_turn, int position_x, int position_y) {
		if(current_turn != this.board[position_x][position_y].get_color())
			return false;
		return true;
	}

	public boolean checkPawnMoveLegal(Pawn pawn, int old_position_x, int old_position_y, int new_position_x, int new_position_y) {
		//TODO check if pawn at origin
		if(pawn.getHasMoved() == false) {
			//TODO if at origin AND 2 moves ahead are clear AND moving doesnt put King in check, allow
				//if has clear 2 and selected allow.

		}
		//TODO if new pos y is +1 clear AND is chosen AND moving doesnt put King in check, allow

		//TODO if 1 piece diagnal left OR right is selected, contains piece, AND does not put king in check

		//TODO if new pos y is +1 clear OR if 1 piece diagnal left OR right is selected AND piece at end of board, AND does not put king in check, allow and promote

		//TODO if en passant
	}
	
	
}
