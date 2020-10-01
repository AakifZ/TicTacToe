package edu.ben.assignments.assignment2;

import java.awt.EventQueue;
import javax.swing.JButton;

/**
 * TicTacToeGame class starts the game and runs the game window
 * @author Aakif Ziauddin
 * @version 1.0
 *
 */

public class TicTacToeGame {
	private TicTacToeBoard board = new TicTacToeBoard();
	static int turns = 0;
/**
 * The main method that starts the game and runs it
 * @param args
 */
	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.playGame();
	}
/*
 * The playGame method runs the game and makes the window visible
 */
	public void playGame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGUI frame = new TicTacToeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				generateComputersMove();

			}
		});
	}
	/**
	 * Places the 'X' and 'O' marker on the array
	 * @param i is the first index (row)
	 * @param j is the second index (column)
	 * @param marker the character 'X' and 'O' that is placed on display
	 */

	public void placeMarker(int i, int j, char marker) {
		board.updateBoard(i, j, marker);
	}

	// finish me
	
	/**
	 * This method checks if the game is done or not and if it has been done it will give back the results of 
	 * if the user or computer won or if it was a tie
	 * @return returns if the player or computer has won or if it has ended in a tie
	 */

	public String gameFinished() {
		JButton[][] btns = TicTacToeButtonListener.getBtns();
		String finalEvalutation = checkRow() + checkColumn() + checkDiag();
		if (finalEvalutation.isEmpty()) {
			if (turns == 9) {
				return "tie";
			}
		}
		return finalEvalutation;
	}
/**
 * checkRow method checks the rows of the array to see if there has been a winner
 * @return returns the marker of who won or an empty string if the game has not been won
 */
	public static String checkRow() {
		JButton[][] btns = TicTacToeButtonListener.getBtns();
		if (btns[0][0].getText() == btns[1][0].getText() && btns[0][0].getText() == btns[2][0].getText()) {
			return btns[0][0].getText();

		} else if (btns[0][1].getText() == btns[1][1].getText() && btns[0][1].getText() == btns[2][1].getText()) {
			return btns[0][1].getText();

		} else if (btns[0][2].getText() == btns[1][2].getText() && btns[0][2].getText() == btns[2][2].getText()) {
			return btns[0][2].getText();
		}
		return ("");
	}
/**
 * checkRow method checks the columns of the array to see if there has been a winner
 * @return returns the marker of who won or an empty string if the game has not been won
 */
	public static String checkColumn() {
		JButton[][] btns = TicTacToeButtonListener.getBtns();
		if (btns[0][0].getText() == btns[0][1].getText() && btns[0][0].getText() == btns[0][2].getText()) {
			return btns[0][0].getText();

		} else if (btns[1][0].getText() == btns[1][1].getText() && btns[1][0].getText() == btns[1][2].getText()) {
			return btns[1][0].getText();

		} else if (btns[2][0].getText() == btns[2][1].getText() && btns[2][0].getText() == btns[2][2].getText()) {
			return btns[2][0].getText();
		}
		return ("");
	}
/**
 * checkRow method checks the columns of the array to see if there has been a winner
 * @return returns the marker of who won or an empty string if the game has not been won
 */
	public static String checkDiag() {
		JButton[][] btns = TicTacToeButtonListener.getBtns();
		if (btns[0][0].getText() == btns[1][1].getText() && btns[0][0].getText() == btns[2][2].getText()) {
			return btns[0][0].getText();

		} else if (btns[0][2].getText() == btns[1][1].getText() && btns[0][2].getText() == btns[2][0].getText()) {
			return btns[0][2].getText();

		}
		return ("");

	}
/**
 * This method executes the computers move by randomly choosing an integer between (0 - 2) and places the computers move in the board as well as on the button 
 */
	public void generateComputersMove() {

		JButton[][] btns = TicTacToeButtonListener.getBtns();
		double moveX = (int) (Math.random() * (2 - 0 + 1) + 0);
		double moveY = (int) (Math.random() * (2 - 0 + 1) + 0);

		if (!btns[(int) moveX][(int) moveY].getText().equals(" ")) {
			generateComputersMove();
		}

		JButton pickedButton = btns[(int) moveX][(int) moveY];
		pickedButton.doClick();

	}
}
