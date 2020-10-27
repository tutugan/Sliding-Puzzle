package uk.ac.man.cs.puzzle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.ac.man.cs.puzzle.gui.GUI;

public class Puzzle extends JPanel {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame window = new JFrame("Slide Puzzle");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GUI(3, 3));
		window.pack(); // finalise layout
		window.setVisible(true);
		window.setResizable(false);
	}

}
