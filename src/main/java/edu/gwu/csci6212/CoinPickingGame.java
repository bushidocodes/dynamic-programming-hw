package edu.gwu.csci6212;

import java.util.*;

public class CoinPickingGame {
    public ArrayList<Integer> coins;
    public ArrayList<Integer> playerOne;
    public ArrayList<Integer> playerTwo;

    CoinPickingGame() {
        this.coins = new ArrayList<Integer>();
        this.playerOne = new ArrayList<Integer>();
        this.playerTwo = new ArrayList<Integer>();
    }

    public void setup(int coins[]) {
        if (hasOddCount(coins) || isEmpty(coins))
            throw new IllegalCapacity();
        reset();
        for (int coin : coins) {
            this.coins.add(coin);
        }
    }

    private boolean hasOddCount(int[] coins) {
        return coins.length % 2 == 1;
    }

    private boolean isEmpty(int[] coins) {
        return coins.length == 0;
    }

    private void reset() {
        this.coins.clear();
        this.playerOne.clear();
        this.playerTwo.clear();
    }

    public int play() {
        while (this.coins.size() > 0) {
            playerOne.add(pickWisestCoin());
            playerTwo.add(pickWisestCoin());
        }
        return calculateTotalValue(this.playerOne);
    }

    private Integer pickWisestCoin() {
        if (isLastRound()) {
            return pickLargestCoin(this.coins);
        } else if (determineScoreIfIPickLargest() >= determineScoreIfIPickSmallest()) {
            return pickLargestCoin(this.coins);
        } else {
            return pickSmallestCoin(this.coins);
        }
    }

    private boolean isLastRound() {
        return this.coins.size() <= 2;
    }

    private int determineScoreIfIPickSmallest() {
        int pickSmallestTotal = 0;
        ArrayList<Integer> pickSmallestHypothetical = new ArrayList<Integer>();
        pickSmallestHypothetical.addAll(this.coins);
        pickSmallestTotal += pickSmallestCoin(pickSmallestHypothetical);
        pickLargestCoin(pickSmallestHypothetical);
        pickSmallestTotal += pickLargestCoin(pickSmallestHypothetical);
        return pickSmallestTotal;
    }

    private int determineScoreIfIPickLargest() {
        int pickLargestTotal = 0;
        ArrayList<Integer> pickLargestHypothetical = new ArrayList<Integer>();
        pickLargestHypothetical.addAll(this.coins);
        pickLargestTotal += pickLargestCoin(pickLargestHypothetical);
        pickLargestCoin(pickLargestHypothetical);
        pickLargestTotal += pickLargestCoin(pickLargestHypothetical);
        return pickLargestTotal;
    }

    private Integer pickLargestCoin(ArrayList<Integer> hypothetical) {
        if (hypothetical.get(0) >= hypothetical.get(hypothetical.size() - 1)) {
            return hypothetical.remove(0);
        } else {
            return hypothetical.remove(hypothetical.size() - 1);
        }
    }

    private Integer pickSmallestCoin(ArrayList<Integer> hypothetical) {
        if (hypothetical.get(0) <= hypothetical.get(hypothetical.size() - 1)) {
            return hypothetical.remove(0);
        } else {
            return hypothetical.remove(hypothetical.size() - 1);
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
