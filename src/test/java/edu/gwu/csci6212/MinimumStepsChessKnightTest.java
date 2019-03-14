package edu.gwu.csci6212;

public class MinimumStepsChessKnightTest {


    public static void  outOfBoad(){
        int size = 7;
        int[] start = new int[]{7, 5};
        int[] goal = new int[]{1, 1};
        executeGame(size, start, goal);
    }

    public static void  startEqualsGoal(){
        int size = 7;
        int[] start = new int[]{1, 1};
        int[] goal = new int[]{1, 1};
        executeGame(size, start, goal);

    }

    public static void  twoSteps(){
        int size = 7;
        int[] start = new int[]{3, 1};
        int[] goal = new int[]{1, 1};
        executeGame(size, start, goal);

    }


    public static void  threeSteps(){
        int size = 7;
        int[] start = new int[]{4, 5};
        int[] goal = new int[]{1, 1};
        executeGame(size, start, goal);

    }


    public static void  fourSteps(){
        int size = 7;
        int[] start = new int[]{1, 1};
        int[] goal = new int[]{6, 6};
        executeGame(size, start, goal);

    }

    public static void executeGame(int size, int[] start, int[] goal){
        MinimumStepsChessKnight myGame = new MinimumStepsChessKnight();
        try{
            myGame.setUpBoard(size, start, goal);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

