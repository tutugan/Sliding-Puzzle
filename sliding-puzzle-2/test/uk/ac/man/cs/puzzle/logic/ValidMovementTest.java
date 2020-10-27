package uk.ac.man.cs.puzzle.logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ValidMovementTest {

	private Model puzzleModel = new Model(3, 3);
	private static int ROWS;
	private static int COLS;

	@Before
	public void setUpPuzzleModel() {
		puzzleModel.reset();
		ROWS = puzzleModel.getRows();
		COLS = puzzleModel.getCols();
	}

	@Test
	public void shouldNotAllowMovementWhenRowAndColOutOfBounds() {
		int outOfBounds = (ROWS * COLS) + 1;
		assertFalse(puzzleModel.moveTile(outOfBounds, -1));
		assertFalse(puzzleModel.moveTile(-1, outOfBounds));
	}

	@Test
	public void shouldNotAllowMovementWhenEitherRowOrColOutOfBounds() {
		int outOfBounds = (ROWS * COLS) + 1;
		assertFalse(puzzleModel.moveTile(outOfBounds, 0));
		assertFalse(puzzleModel.moveTile(0, outOfBounds));
	}

	@Test
	public void shouldNotAllowMovementWhenBothTilesOccupied() {
		// In the starting position of a reset puzzle the only
		// space which is not occupied is tile (ROW-1, COL-1)
		assertFalse(puzzleModel.moveTile(0, 0));
	}

	@Test
	public void shouldAllowMovementWhenAdjacentTileIsEmpty() {
		assertTrue(puzzleModel.moveTile(1, 2));
		puzzleModel.reset();
		assertTrue(puzzleModel.moveTile(2, 1));
	}

}
