package uk.ac.man.cs.puzzle.gui;

import static org.junit.Assert.*;

import javax.swing.Timer;

import org.junit.Before;
import org.junit.Test;

import uk.ac.man.cs.puzzle.logic.Model;

public class TimerTest {

	private static final int ROWS = 2, COLS = 2;

	private GUI gui;
	private Model puzzleModel;
	private Timer timer;

	@Before
	public void setUpPuzzleGUI() {
		gui = new GUI(ROWS, COLS);
		puzzleModel = gui.getPuzzleModel();
		timer = gui.getGameTimer();

		// Load an unfinished game one move away from completion, by moving the tile at
		// (1,0) to (1,1). Puzzle state is:
		// 1 2
		// - 3
		puzzleModel.reset();
		puzzleModel.moveTile(1, 0);
	}

	@Test
	public void shouldStartTimerWhenGUIIsLoaded() {
		assertTrue(timer.isRunning());
	}

	@Test
	public void shouldStopTimerWhenGameOver() throws InterruptedException {
		// Force the game to be completed by making the final move
		puzzleModel.moveTile(1, 1);
		assertTrue(puzzleModel.gameOver());

		// Force the timer to tick, so the finished game is noticed
		timer.getActionListeners()[0].actionPerformed(null);

		assertFalse(timer.isRunning());
	}

	@Test
	public void shouldRestartTimerWhenNewGameStarted() {
		// Stop the timer, to simulate the end of the previous game
		timer.stop();

		// Simulate pressing the New Game button
		gui.new NewGameAction().actionPerformed(null);
		assertTrue(timer.isRunning());
	}
}
