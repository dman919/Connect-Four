//David Man 111940002
import java.util.Scanner;

public class Connect_Four
{
	private static int turn = 0;
	private static int col0 = 5;
	private static int col1 = 5;
	private static int col2 = 5;
	private static int col3 = 5;
	private static int col4 = 5;
	private static int col5 = 5;
	private static int col6 = 5;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		//generating initial empty board
		String[][] board = new String[6][7];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = " |";
			}
		}
		System.out.println();
		printBoard(board);
		
		//status of game
		while (!RedWin(board) || !YellowWin(board) || !draw()) {
			//Status is: Draw
			if (draw()) {
				System.out.print("It is a draw");
				break;
			}
			
			//Status is: Red Wins
			if (RedWin(board)) {
				System.out.print("The Red Player Won");
				break;
			}
			
			//Status is: Yellow Wins
			if (YellowWin(board)) {
				System.out.print("The Yellow Player Won");
				break;				
			}
			
			//Status is: Continue
			if (turn % 2 == 0) {
				System.out.print("Drop a red disk at column (0 - 6): ");
			}
			if(turn % 2 != 0) {
				System.out.print("Drop a Yellow disk at colum (0 - 6): ");
			}
			int column = input.nextInt();
			//Display board with new input
			if (column < 7 && column >= 0) {
				System.out.println();
				printBoard(Placement(board, column));
				turn++;
			}
			
			//exception for invalid input
			else {
				System.out.println("Invalid input, enter an integer between 0 - 6\n");
			}
		}
	}
	
	//board placement method
	public static String[][] Placement(String[][] board, int col) {
		if (turn % 2 == 0) {
			switch (col) {
				case 0: board[col0][col] = "R|";
						col0--;
						break;
				case 1: board[col1][col] = "R|";
						col1--;
						break;
				case 2: board[col2][col] = "R|";
						col2--;
						break;
				case 3: board[col3][col] = "R|";
						col3--;
						break;
				case 4: board[col4][col] = "R|";
						col4--;
						break;
				case 5: board[col5][col] = "R|";
						col5--;
						break;
				case 6: board[col6][col] = "R|";
						col6--;
						break;
			}
		}

		if (turn % 2 != 0) {
			switch (col) {
				case 0: board[col0][col] = "Y|";
						col0--;
						break;
				case 1: board[col1][col] = "Y|";
						col1--;
						break;
				case 2: board[col2][col] = "Y|";
						col2--;
						break;
				case 3: board[col3][col] = "Y|";
						col3--;
						break;
				case 4: board[col4][col] = "Y|";
						col4--;
						break;
				case 5: board[col5][col] = "Y|";
						col5--;
						break;
				case 6: board[col6][col] = "Y|";
						col6--;
						break;
			}
		}

		return board;
	}
	
	//board display method
	public static void printBoard(String[][] board) {		
		for (int i = 0; i < board.length; i++) {
			System.out.print("|");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println("...............\n");
    }
	
	//Status Method: Win(Red)
	public static boolean RedWin(String[][] board) {
		int count = 0;

		//horizontal win
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == "R|") {
					count++;
				}
				if (board[i][j] == "Y|" || board[i][j] == " |") {
					count = 0;
				}
				if (count == 4) {
					return true;
				}
			}
		}
		
		//vertical win
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[j][i] == "R|") {
					count++;
				}
				if (board[j][i] == "Y|" || board[j][i] == " |") {
					count = 0;
				}
				if (count == 4) {
					return true;
				}
			}
		}
		
		//diagonal win
		for (int i = 3; i < board.length; i++) {
	    	for (int j = 0; j < board[0].length - 3; j++) {
	    		if (board[i][j] == "R|" && board[i - 1][j + 1] == "R|" && board[i - 2][j + 2] == "R|" && board[i - 3][j + 3] == "R|") {
	    			return true;
	    		}
	    	}
	    }
		for (int i=3; i < board.length; i++) {
			for (int j = 3; j < board[0].length; j++) {
				if (board[i][j] == "R|" && board[i - 1][j - 1] == "R|" && board[i - 2][j - 2] == "R|" && board[i - 3][j - 3] == "R|") {
					return true;
				}
			}
		}
		
		return false;
	}
	
	//Status Method: Win(Yellow)
	public static boolean YellowWin(String[][] board) {
		int count = 0;

		//horizontal win
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == "Y|") {
					count++;
				}
				if (board[i][j] == "R|" || board[i][j] == " |") {
					count = 0;
				}
				if (count == 4) {
					return true;
				}
			}
		}
		
		//vertical win
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[j][i] == "Y|") {
					count++;
				}
				if (board[j][i] == "R|" || board[j][i] == " |") {
					count = 0;
				}
				if (count == 4) {
					return true;
				}
			}
		}
		
		//diagonal win
		for (int i = 3; i < board.length; i++) {
	    	for (int j = 0; j < board[0].length - 3; j++) {
	    		if (board[i][j] == "Y|" && board[i - 1][j + 1] == "Y|" && board[i - 2][j + 2] == "Y|" && board[i - 3][j + 3] == "Y|") {
	    			return true;
	    		}
	    	}
	    }

		for (int i=3; i < board.length; i++) {
			for (int j = 3; j < board[0].length; j++) {
				if (board[i][j] == "Y|" && board[i - 1][j - 1] == "Y|" && board[i - 2][j - 2] == "Y|" && board[i - 3][j - 3] == "Y|") {
					return true;
				}
			}
		}

		return false;
	}

	//Status Method: Draw
	public static boolean draw() {
		if (col0 < 0 && col1 < 0 && col2 < 0 && col3 < 0 && col4 < 0 && col5 < 0 && col6 < 0) {
			return true;
		}
		else {
			return false;
		}
	}
}