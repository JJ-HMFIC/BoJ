package study_algorithm.week5;

import java.util.LinkedList;
import java.util.Queue;

public class leet_coin_change {
    static boolean visited[];

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) return 0;
        visited = new boolean[amount + 1];

        int result = BFS(coins, amount);
        return result;
    }

    private int BFS(int[] coins, int amount) {
        Queue<Coin> queue = new LinkedList<>();
        queue.add(new Coin(0, 0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Coin top = queue.poll();
            int nextAmount = top.getAmount();
            int nextCount = top.getCount();

            if (nextAmount == amount) {
                return nextCount;
            }

            for (int coin : coins) {
                if (nextAmount > amount - coin) continue;
                int newCount = nextCount + 1;
                int newAmount = nextAmount + coin;
                if (!visited[newAmount]) {
                    queue.offer(new Coin(newCount, newAmount));
                    visited[newAmount] = true;
                }
            }
        }
        return -1;
    }
}

class Coin {
    int count;
    int amount;

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public Coin(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }
}