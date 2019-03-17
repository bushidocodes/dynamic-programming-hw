package edu.gwu.csci6212;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MinimumStepsChessKnightTest {
    static MinimumStepsChessKnight myGame;

    @Test
    public void  doesNotAcceptCoordinatesOutOfBounds(){
        int size = 7;
        int[] start = new int[]{7, 5};
        int[] goal = new int[]{1, 1};
        myGame = new MinimumStepsChessKnight();
        assertEquals(-1, myGame.startGame(size, start, goal));
    }

    @Test
    public void  startPositionEqualsGoalPosition(){
        int size = 7;
        int[] start = new int[]{1, 1};
        int[] goal = new int[]{1, 1};
        myGame = new MinimumStepsChessKnight();
        assertEquals(0, myGame.startGame(size, start, goal));


    }

    @Test
    public void  startIsTwoStepsFromGoal(){
        int size = 7;
        int[] start = new int[]{3, 1};
        int[] goal = new int[]{1, 1};
        myGame = new MinimumStepsChessKnight();
        assertEquals(2, myGame.startGame(size, start, goal));


    }


    @Test
    public void  startIsThreeStepsFromGoal(){
        int size = 7;
        int[] start = new int[]{4, 5};
        int[] goal = new int[]{1, 1};
        myGame = new MinimumStepsChessKnight();
        assertEquals(3, myGame.startGame(size, start, goal));


    }


    @Test
    public void  startIsFourStepsFromGoal(){
        int size = 7;
        int[] start = new int[]{1, 1};
        int[] goal = new int[]{6, 6};
        myGame = new MinimumStepsChessKnight();
        assertEquals(4, myGame.startGame(size, start, goal));


    }


}
