package edu.gwu.csci6212;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import org.junit.Test;

import edu.gwu.csci6212.MaxPoints.IllegalCapacity;

/**
 * Unit test for simple App.
 */
public class MaxPointsTest {
    static MaxPoints game;

    @Before
    public void setup() {
        game = new MaxPoints();
    }

    @Test(expected = IllegalCapacity.class)
    public void doesNotAcceptAnOddNumberOfCoins() {
        int coins[] = { 1, 1, 1 };
        game.setup(coins);
    }

    @Test(expected = IllegalCapacity.class)
    public void doesNotAcceptZeroCoins() {
        int coins[] = {};
        game.setup(coins);
    }

    @Test
    public void acceptAnEvenNumberOfCoins() {
        int coins[] = { 1, 1, 1, 1 };
        game.setup(coins);
    }

    @Test
    public void playReturnsAPositiveResult() {
        int coins[] = { 1, 1, 1, 1 };
        game.setup(coins);
        assertTrue(game.play() > 0);
    }

    @Test
    public void returnsExpectedTotals() {
        // int coins[] = { 5, 3, 7, 10 };
        // game.setup(coins);
        // assertEquals(15, game.play());
        MaxPoints gameTwo = new MaxPoints();
        int coinsTwo[] = { 8, 15, 3, 7 };
        gameTwo.setup(coinsTwo);
        assertEquals(22, gameTwo.play());
    }

}
