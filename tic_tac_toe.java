import java.util.Iterator;
import java.util.Scanner;

public class tic_tac_toe {

	public static void main(String[] args) {
		char[][] board  = new char[3][3];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = ' ';
			}
		}
		char player = 'X';
		boolean gameover = false;
		Scanner sc = new Scanner(System.in);
		
		while(!gameover) {
			printboard(board);
			System.out.println("Player "+player+" enter: ");
			int row = sc.nextInt();
			int col = sc.nextInt();
			if(board[row][col]==' ') {
				board[row][col] = player;
				gameover = havewon(board,player);
				if(gameover) {
					System.out.println("Player "+player+" has won");
					printboard(board);
				}else {
					player = (player=='X') ? 'O':'X';
				}
			}else {
				System.out.println("Invalid move");
			}
		}
	}

	private static boolean havewon(char[][] board, char player) {
		// TODO Auto-generated method stub
		// row check
		for (int i = 0; i < board.length; i++) {
			if(board[i][0] == player && board[i][1] == player && board[i][2]==player)
				return true;
		}  
		
		// column check
				for (int i = 0; i < board.length; i++) {
					if(board[0][i] == player && board[1][i] == player && board[2][i]==player)
						return true;
				}  
				
	  // diagonal check

		if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
			return true;
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
			return true;
		
		return false;
	}

	private static void printboard(char[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
