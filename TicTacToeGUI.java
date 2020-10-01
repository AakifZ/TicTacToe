package edu.ben.assignments.assignment2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 * This GUI class is the user interface for the game window of the TicTacToe gmae with 9 buttons
 * @author Aakif Ziauddin
 * @version 1.0
 *
 */

public class TicTacToeGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//private JPanel
	private JPanel contentPane;

	final Font f = new Font("Dialog", Font.PLAIN, 64);
	TicTacToeGame game = new TicTacToeGame(); 
	final JButton[][] btns = new JButton[3][3];
	TicTacToeBoard gameBoard = new TicTacToeBoard();
/**
 * Public Constructor that sets up the TicTacToe window
 */
	public TicTacToeGUI() {

		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
	

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btns[i][j] = new JButton(" ");
				ActionListener actionListener = new TicTacToeButtonListener(game, i, j, btns);
				btns[i][j].addActionListener(actionListener);
				add(btns[i][j]);
			}
		}
	
	}	
}