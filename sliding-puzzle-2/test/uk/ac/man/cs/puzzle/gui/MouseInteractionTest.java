package uk.ac.man.cs.puzzle.gui;

import static org.junit.Assert.assertArrayEquals;

import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

public class MouseInteractionTest {

	private GUI gui;
	private GraphicsPanel puzzleGraphics;
	private static final int ROWS = 3, COLS = 3;
	private static int CELL_SIZE = 80;

	@Before
	public void setUpGUI() {
		gui = new GUI(ROWS, COLS);
		puzzleGraphics = gui.getGraphicsPanel();
	}

	@Test
	public void guiReturnsCorrectXYFromFirstTileCoordinates() {
		MouseEvent e = new MouseEvent(gui, 0, 0, 0, CELL_SIZE / 2, CELL_SIZE / 2, 0, false);
		int[] tile = puzzleGraphics.getTileRCFromCoordinates(e);
		int[] expected = { 0, 0 };
		assertArrayEquals(expected, tile);
	}

	@Test
	public void guiReturnsCorrectXYFromLastTileCoordinates() {
		int y = CELL_SIZE / 2 + CELL_SIZE * (ROWS - 1);
		int x = CELL_SIZE / 2 + CELL_SIZE * (COLS - 1);
		MouseEvent e = new MouseEvent(gui, 0, 0, 0, x, y, 0, false);
		int[] tile = puzzleGraphics.getTileRCFromCoordinates(e);
		int[] expected = { COLS - 1, ROWS - 1 };
		assertArrayEquals(expected, tile);
	}

	@Test
	public void guiReturnsCorrectXYFromMiddleTileCoordinates() {
		int y = CELL_SIZE / 2 + CELL_SIZE * ((int) ((ROWS - 1) / 2));
		int x = CELL_SIZE / 2 + CELL_SIZE * ((int) ((COLS - 1) / 2));
		MouseEvent e = new MouseEvent(gui, 0, 0, 0, x, y, 0, false);
		int[] tile = puzzleGraphics.getTileRCFromCoordinates(e);
		int[] expected = { (int) ((COLS - 1) / 2), (int) ((ROWS - 1) / 2) };
		assertArrayEquals(expected, tile);
	}

	@Test
	public void guiReturnsCorrectXYFromTopRightCorner() {
		int y = CELL_SIZE / 2;
		int x = CELL_SIZE / 2 + CELL_SIZE * (COLS - 1);
		MouseEvent e = new MouseEvent(gui, 0, 0, 0, x, y, 0, false);
		int[] tile = puzzleGraphics.getTileRCFromCoordinates(e);
		int[] expected = { COLS - 1, 0 };
		assertArrayEquals(expected, tile);
	}

	@Test
	public void guiReturnsCorrectXYFromBottomLeftCorner() {
		int x = CELL_SIZE / 2;
		int y = CELL_SIZE / 2 + CELL_SIZE * (ROWS - 1);
		MouseEvent e = new MouseEvent(gui, 0, 0, 0, x, y, 0, false);
		int[] tile = puzzleGraphics.getTileRCFromCoordinates(e);
		int[] expected = { 0, ROWS - 1 };
		assertArrayEquals(expected, tile);
	}
}
