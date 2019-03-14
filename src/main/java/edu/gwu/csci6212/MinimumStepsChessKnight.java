package edu.gwu.csci6212;


import java.util.LinkedList;

public class MinimumStepsChessKnight {

    private int [][] board;
    private int[] start;
    private int[] goal;
    private LinkedList<int[]> queue;
    private boolean gameOver;
    private int[][] knightMovements;
    private int size;
    private int totalSteps;

    public MinimumStepsChessKnight(){
        this.start = new int[3];
        this.goal = new int[3];
        this.queue = new LinkedList<>();
        this.gameOver = false;

        this.knightMovements = new int [][] {
                //x y step
                {1, 2, 1},
                {1, -2, 1},
                {2, 1, 1},
                {2, -1, 1},
                {-2, 1, 1},
                {-2, -1, 1},
                {-1, 2, 1},
                {-1, -2, 1}
        };

    }

    public void setUpBoard(int size, int[] start, int[] goal) throws Exception{
        this.size = size;
        board = new int[size][size];
        this.start[0] = start[0];
        this.start[1] = start[1];
        this.start[2] = 0;
        this.goal = goal;
        if (outOfBoard()) throw new Exception("Position out of board");
        board [start[0]][start[1]] = 1;
        if (!isKnightInGoal()){
            startGame();
        }
    }

    public void startGame(){
        queue.add(start);
        while(!gameOver){
            calculateSquares(queue.remove());
        }
        System.out.println("The knight can find the goal in " + totalSteps + " steps.");
    }

    public void calculateSquares(int[] origin){
        for (int [] knightMove : knightMovements){
            int [] temp = new int[3];
            calculateMovement(temp, origin, knightMove);
            if(isInsideLimits(temp)){
                if(!isUsed(temp)){
                    makeMovement(temp);
                }
            }
            isGameOver(temp);
        }
    }

    private boolean outOfBoard(){
        if(start[0] > size - 1 || start[0] < 0 || start[1] > size -1 || start[1] < 0) return true;
        return goal[0] > size - 1 || goal[0] < 0 || goal[1] > size - 1 || goal[1] < 0;

    }

    private boolean isKnightInGoal(){
        if (start[0] == goal[0] && start[1] == goal[1]){
            System.out.println("You are already in your goal position!");
            return  true;
        }
        return false;
    }

    private boolean isInsideLimits(int[] temp){
        return temp[0] < size && temp[1] < size && temp[0] > 0 && temp[1] > 0;
    }

    private boolean isUsed(int[] temp){
        return (board[temp[0]][temp[1]] == 1);
    }

    private void makeMovement(int[] temp){
        queue.add(temp);
        board[temp[0]][temp[1]] =1;
    }

    private void calculateMovement(int[] temp, int[] origin, int[] knightMove){
        for(int i =0; i < 3; i++){
            temp[i] = origin[i] + knightMove[i];
        }
    }

    private void isGameOver(int[] temp){
        if(temp[0] == goal[0] && temp[1] == goal[1]){
            gameOver = true;
            totalSteps = temp[2];
        }
    }
}


