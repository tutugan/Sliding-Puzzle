package uk.ac.man.cs.puzzle.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTimerTest {

	private Model puzzleModel = new Model(3, 3);

	@Before
	public void setUpPuzzleModel() {
		puzzleModel.reset();
	}

	@Test
	public void shouldSetGameTimeToZeroWhenGameLoads() {
		assertEquals(0, puzzleModel.getGameTime());
	}

	@Test
	public void shouldIncrementGameTimeByOneOnRequest() {
		puzzleModel.incrementGameTime();
		puzzleModel.incrementGameTime();
		puzzleModel.incrementGameTime();
		assertEquals(3, puzzleModel.getGameTime());
	}

	@Test
	public void shouldResetGameTimeToZeroWhenGameReset() {
		puzzleModel.incrementGameTime();
		assertEquals(1, puzzleModel.getGameTime());
		puzzleModel.reset();
		assertEquals(0, puzzleModel.getGameTime());
	}
}
