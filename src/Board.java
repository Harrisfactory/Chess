
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
		

		//moves piece
		this.board[new_position_x][new_position_y] = piece;
		this.board[old_position_x][old_position_y] = null;
	}
	
	public boolean checkTurnToPiece(char current_turn, int position_x, int position_y) {
		
		if(current_turn != this.board[position_x][position_y].get_color())
			return false;
		return true;
	}
	
	
}
