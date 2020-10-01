package edu.ben.assignments.assignment2;
/**
 * TicTacToeBoard class which initializes the board and introduces the Player and computer input and 
 * checks if there are any location in the array that are taking space so user or computer can place their markers
 * @author Aakif Ziauddin
 * @version 1.0
 *
 */
public class TicTacToeBoard {
	//The char value of the Player
	final public static char PLAYER = 'X';
	//The char value of the Computer
	final public static char COMPUTER = 'O';
	//The int value of the spaces on the board
	final public static int NUM_SPACES = 3;
	private char[][] board;
/**
 * Initializes the board by making a 3 by 3 array
 */
	public TicTacToeBoard() {
		board = new char[NUM_SPACES][NUM_SPACES];
	}
/**
 * Checks if the board has any markers in a specific location on the array and if they do not,
 * then the marker can be placed on board
 * @param i is the first array index in the board
 * @param j is the second array index in the board
 * @param marker is the marker 'X' that is going to be placed 
 * @return returns true if board doesn't have any markers in checked locations, returns false if board is filled 
 * with player and computer inputs
 */
	public boolean updateBoard(int i, int j, char marker) {
		if (board[i][j] != PLAYER && board[i][j] != COMPUTER) {
			board[i][j] = marker;
			return true;
		}
		return false;
	}

	/**
	 * gets the private board array so it can be used in other classes
	 * @return returns board so the private char array can be used temporarily 
	 */
	public char [][] getboard(){
		return board;
	}
}