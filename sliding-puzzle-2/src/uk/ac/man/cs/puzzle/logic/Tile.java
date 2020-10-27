package uk.ac.man.cs.puzzle.logic;

//Represents the individual "tiles" that slide in puzzle.
public class Tile {

	private int row; // row of final position
	private int col; // column of final position
	private String face; // string to display

	public Tile(int r, int c, String f) {
		row = r;
		col = c;
		face = f;
	}

	public void setFace(String newFace) {
		face = newFace;
	}

	public String getFace() {
		return face;
	}

	public boolean isInFinalPosition(int r, int c) {
		return r == row && c == col;
	}
}