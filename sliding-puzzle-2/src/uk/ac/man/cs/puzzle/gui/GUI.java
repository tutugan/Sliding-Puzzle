package uk.ac.man.cs.puzzle.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uk.ac.man.cs.puzzle.logic.Model;

public class GUI extends JPanel{

	private static final long serialVersionUID = 1L;
	private final Model puzzleModel;
	private GraphicsPanel puzzleGraphics;
	private int ROWS;
	private int COLS;
	private static int counter;
	static JLabel currentMovesLabel;
	JLabel label1;

	public GUI(int rows, int cols)  {
		// Create a button. Add a listener to it.
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new NewGameAction());
		
		JLabel moveLabel= new JLabel("Moves:", JLabel.LEADING);
		JLabel label1=new JLabel ("0", JLabel.CENTER);
		currentMovesLabel=label1;
		// Create control panel
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(newGameButton);

		// Create graphics panel
		ROWS = rows;
		COLS = cols;
		puzzleModel = new Model(ROWS, COLS);
		puzzleGraphics = new GraphicsPanel(puzzleModel, rows, cols);
		
		JPanel movesPanel = new JPanel();
		movesPanel.setLayout(new FlowLayout());
		movesPanel.add(moveLabel);
		movesPanel.add(currentMovesLabel);

		// Set the layout and add the components
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(puzzleGraphics, BorderLayout.CENTER);
		this.add(movesPanel, BorderLayout.SOUTH);
		
		
		
	}

	Model getPuzzleModel() {
		return puzzleModel;
	}

	GraphicsPanel getGraphicsPanel() {
		return puzzleGraphics;
	}
	
	public static void increase() {
		counter++;
		currentMovesLabel.setText(String.valueOf(counter));
	}
	
	
	
	public class NewGameAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			puzzleModel.reset();
			counter=puzzleModel.getMoveCount();
			currentMovesLabel.setText(String.valueOf(counter));
			puzzleModel.shuffle();
			puzzleGraphics.repaint();
			puzzleGraphics.setBackground(Color.black);
		}
	}
}
