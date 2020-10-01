package edu.ben.assignments.assignment2;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 * 
 * TicTacToeButtonListener class uses the ActionListener to make that program have buttons that work
 * @author Aakif Ziauddin
 * @version 1.0
 *
 */
public class TicTacToeButtonListener implements ActionListener {
	//private instance of the static game class
	private static TicTacToeGame game;
	//the horizontal position that is clicked on the array
	private int posX;
	//the vertical position that is clicked on the array
	private int posY;
	private static JButton[][] btns;
	//Instantiation of the TicTacToeGame class 
	TicTacToeGame TicTacGame = new TicTacToeGame();
	final Font f = new Font("Dialog", Font.PLAIN, 64);
	
	/**
	 *Buttons for the program that will also keep track of the array indices 
	 * @param game is the TicTacToeGame class
	 * @param posX is the horizontal position of the board
	 * @param posY is the vertical position of the baord
	 * @param btns is the buttons on the board
	 */

	public TicTacToeButtonListener(TicTacToeGame game, int posX, int posY, JButton[][] btns) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		this.btns = btns;
	}
/**
 * The method that takes in the users click and checks the index which is clicked by the user.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean goodOption = true;

		if (!btns[posX][posY].getText().equals(" ")) {
			goodOption = false;
		}

		if (TicTacToeGame.turns % 2 == 0 && goodOption == true) {
			TicTacToeGame.turns++;
			game.placeMarker(posX, posY, TicTacToeBoard.COMPUTER);
			updateButton(btns, 'O');
		} else if (goodOption == true) {
			TicTacToeGame.turns++;
			game.placeMarker(posX, posY, TicTacToeBoard.PLAYER);
			updateButton(btns, 'X');

			if (winColor() == false) {
				TicTacGame.generateComputersMove();
			}
		}

		goodOption = true;
		winColor();
	}
/**
 * Boolean method that Changes the background of the whole board to see if the game ends in the win, lose, or draw
 * @return returns true if game has been finished with a win, loss, or draw, returns 
 * false if game has not reached those results
 */
	public boolean winColor() {
		if (TicTacGame.gameFinished().equals("X")) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					btns[i][j].setBackground(Color.green);
					btns[i][j].setEnabled(false);
				}
			}
			return true;
		} else if (TicTacGame.gameFinished().equals("O")) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					btns[i][j].setBackground(Color.red);
					btns[i][j].setEnabled(false);
				}
			}
			return true;
		} else if (TicTacGame.gameFinished().equals("tie")) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					btns[i][j].setBackground(Color.blue);
					btns[i][j].setEnabled(false);
				}
			}
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Class gives the value of 'X' for players input and 'O' for computers input
	 * @param btns is the buttons on the board and where it is on the board
	 * @param marker is the X and O for the respectable user or computer
	 */

	public void updateButton(JButton[][] btns, char marker) {

		if (marker == 'O') {
			btns[posX][posY].setText("O");
			btns[posX][posY].setFont(f);

		} else if (marker == 'X') {
			btns[posX][posY].setText("X");
			btns[posX][posY].setFont(f);
		}
	}
	
	/**
	 * Returns the private JButton Array
	 * @return returns the 2d Array JButton
	 */

	public static JButton[][] getBtns() {
		return btns;
	}
/**
 * gets the private class Game
 * @return returns the game 
 */
	public static TicTacToeGame getGame() {
		return game;
	}
}
