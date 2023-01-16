
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
		if(this.board[position_x][position_y] != null)
			return true;
		return false;
	}
	

	//TODO make boolean based on legality of move
	public void movePiece(int old_position_y, int old_position_x, int new_position_y, int new_position_x) {

		//get piece
		//TODO if exists
		Piece piece = board[old_position_y][old_position_x];
		System.out.print(piece.get_type());
		//TODO check legal
		if(piece.get_type() == "p") {
			Pawn pawn = (Pawn)piece;
			boolean is_legal = checkPawnMoveLegal(pawn, old_position_y, old_position_x,  new_position_y, new_position_x);
			if(is_legal == false)
				return;
		}

		//moves piece
		this.board[new_position_y][new_position_x] = piece;
		this.board[old_position_y][old_position_x] = null;
	}
	
	public boolean checkTurnToPiece(char current_turn, int position_x, int position_y) {
		if(current_turn != this.board[position_x][position_y].get_color())
			return false;
		return true;
	}

	public boolean checkPawnMoveLegal(Pawn pawn, int old_position_y, int old_position_x, int new_position_y, int new_position_x) {
		//TODO check if pawn at origin
		if(pawn.getHasMoved() == false) {
			//TODO up to 2 moves ahead are clear AND moving doesn't put King in check, allow
				//if pawn is at origin
				//if has clear 2 and selected allow
				if(new_position_y <= 2 + old_position_y) {
					//TODO check if king is not in check
					//check clear
					int pawn_move_count = old_position_y - 1;
					while(pawn_move_count >= new_position_y) {
						//is this place clear or does it have a piece?
						System.out.print(isPiece(new_position_x, pawn_move_count));
						if(isPiece(new_position_x, pawn_move_count)) {
							System.out.println("Your piece is colliding");
							return false;
						}
						pawn_move_count--;
					}

					return true;
				}

			return true;
		}
		//TODO if new pos y is +1 clear AND is chosen AND moving doesnt put King in check, allow

		//TODO if 1 piece diagnal left OR right is selected, contains piece, AND does not put king in check

		//TODO if new pos y is +1 clear OR if 1 piece diagnal left OR right is selected AND piece at end of board, AND does not put king in check, allow and promote

		//TODO if en passant
		return true;
	}
	
	
}
