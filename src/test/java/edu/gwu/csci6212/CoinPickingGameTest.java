package edu.gwu.csci6212;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.gwu.csci6212.CoinPickingGame.IllegalCapacity;

public class CoinPickingGameTest {
    static CoinPickingGame game;

    @Before
    public void setup() {
        game = new CoinPickingGame();
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
    public void optimizesWhenGreedyIsSufficient() {
        int coins[] = { 5, 3, 7, 10 };
        game.setup(coins);
        assertEquals(15, game.play());
    }

    @Test
    public void optimizesWhenGreedyIsInsufficient() {
        int coins[] = { 8, 15, 3, 7 };
        game.setup(coins);
        assertEquals(22, game.play());
    }

}
