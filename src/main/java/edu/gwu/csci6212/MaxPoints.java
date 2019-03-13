package edu.gwu.csci6212;

import java.util.*;

public class MaxPoints {
    public ArrayList<Integer> coins;
    public ArrayList<Integer> playerOne;
    public ArrayList<Integer> playerTwo;

    MaxPoints() {
        this.coins = new ArrayList<Integer>();
        this.playerOne = new ArrayList<Integer>();
        this.playerTwo = new ArrayList<Integer>();
    }

    public void setup(int coins[]) {
        this.coins.clear();
        this.playerOne.clear();
        this.playerTwo.clear();
        if (hasOddCount(coins) || isEmpty(coins))
            throw new IllegalCapacity();
        for (int coin : coins) {
            this.coins.add(coin);
        }
    }

    public int play() {
        while (this.coins.size() > 0) {
            playerOne.add(pickLargestCoin());
            playerTwo.add(pickLargestCoin());
        }
        return calculateTotalValue(this.playerOne);

    }

    private boolean hasOddCount(int[] coins) {
        return coins.length % 2 == 1;
    }

    private boolean isEmpty(int[] coins) {
        return coins.length == 0;
    }

    private Integer pickLargestCoin() {
        if (this.coins.get(0) >= this.coins.get(this.coins.size() - 1)) {
            System.out.printf("%d", this.coins.get(0));
            return this.coins.remove(0);
        } else {
            System.out.printf("%d", this.coins.size() - 1);
            return this.coins.remove(this.coins.size() - 1);
        }
    }

    private int calculateTotalValue(ArrayList<Integer> coins) {
        Optional<Integer> sum = coins.stream().reduce((valOne, valTwo) -> valOne + valTwo);
        return sum.isPresent() ? sum.get() : 0;
    }

    public static class IllegalCapacity extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }

}
