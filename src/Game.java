import java.util.Scanner;



public class Game {
	
	private String message;
	
	public Game(){
		
		//initialize pieces
		Pawn p1 = new Pawn('w');
		Pawn p2 = new Pawn('w');
		Pawn p3 = new Pawn('w');
		Pawn p4 = new Pawn('w');
		Pawn p5 = new Pawn('w');
		Pawn p6 = new Pawn('w');
		Pawn p7 = new Pawn('w');
		Pawn p8 = new Pawn('w');
		
		Pawn p9 = new Pawn('b');
		Pawn p10 = new Pawn('b');
		Pawn p11 = new Pawn('b');
		Pawn p12 = new Pawn('b');
		Pawn p13 = new Pawn('b');
		Pawn p14 = new Pawn('b');
		Pawn p15 = new Pawn('b');
		Pawn p16 = new Pawn('b');
		
		Rook r1 = new Rook('w');
		Rook r2 = new Rook('w');
		Rook r3 = new Rook('b');
		Rook r4 = new Rook('b');
		
		Queen q1 = new Queen('w');
		Queen q2 = new Queen('b');
		
		King k1 = new King('w');
		King k2 = new King('b');
		
		Bishop b1 = new Bishop('w');
		Bishop b2 = new Bishop('w');
		Bishop b3 = new Bishop('b');
		Bishop b4 = new Bishop('b');
		
		Knight n1 = new Knight('w');
		Knight n2 = new Knight('w');
		Knight n3 = new Knight('b');
		Knight n4 = new Knight('b');
		
		//initialize Board
		Board board = new Board();
		
		board.add_piece(p1, 6, 0);
		board.add_piece(p2, 6, 1);
		board.add_piece(p3, 6, 2);
		board.add_piece(p4, 6, 3);
		board.add_piece(p5, 6, 4);
		board.add_piece(p6, 6, 5);
		board.add_piece(p7, 6, 6);
		board.add_piece(p8, 6, 7);
		board.add_piece(r1, 7, 0);
		board.add_piece(r2, 7, 7);
		board.add_piece(q1, 7, 4);
		board.add_piece(k1, 7, 3);
		board.add_piece(b1, 7, 2);
		board.add_piece(b2, 7, 5);
		board.add_piece(n1, 7, 1);
		board.add_piece(n2, 7, 6);
		
		board.add_piece(p9, 1, 0);
		board.add_piece(p10, 1, 1);
		board.add_piece(p11, 1, 2);
		board.add_piece(p12, 1, 3);
		board.add_piece(p13, 1, 4);
		board.add_piece(p14, 1, 5);
		board.add_piece(p15, 1, 6);
		board.add_piece(p16, 1, 7);
		board.add_piece(r3, 0, 0);
		board.add_piece(r4, 0, 7);
		board.add_piece(q2, 0, 4);
		board.add_piece(k2, 0, 3);
		board.add_piece(b3, 0, 2);
		board.add_piece(b4, 0, 5);
		board.add_piece(n3, 0, 1);
		board.add_piece(n4, 0, 6);
		
		board.display_board();
		
		boolean game_loop = true;
		
		Scanner reader = new Scanner(System.in);
		
		char current_turn = 'w';
		
		while(game_loop) {
			System.out.println("enter piece you want to move");
			String move_from = reader.next();
			String[] move_from_clean = move_from.split(",");
			System.out.println("enter where you want to move piece");
			String move_to = reader.next();	
			String[] move_to_clean = move_to.split(",");
			
			int old_position_x = Integer.parseInt(move_from_clean[0]);
			int old_position_y = Integer.parseInt(move_from_clean[1]);
			int new_position_x = Integer.parseInt(move_to_clean[0]);
			int new_position_y = Integer.parseInt(move_to_clean[1]);
			
			boolean check_turn = board.checkTurnToPiece(current_turn, old_position_x, old_position_y);
			if(check_turn) {
				board.movePiece(old_position_x, old_position_y, new_position_x, new_position_y);
				board.display_board();
				current_turn = change_turn(current_tu1rn);
			} else {
				System.out.println("You cannot move your opponents piece!");
			}
		}
		
		board.display_board();
	}
	
	public char change_turn(char current_turn) {
		if(current_turn == 'w')
			return current_turn = 'b';
		return current_turn = 'w';
	}
}
