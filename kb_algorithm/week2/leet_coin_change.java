package kb_algorithm.week2;

import java.util.LinkedList;
import java.util.Queue;

public class leet_coin_change {
    static boolean[] visited;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        visited = new boolean[amount + 1]; // 방문했는지 체크하는 배열

        int result = BFS(coins, amount);
        return result;
    }

    private int BFS(int[] coins, int amount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); //금액, 개수
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cur_amount = now[0];
            int cnt = now[1];
            if (cur_amount == amount) return cnt;

            for (int coin : coins) {
                int next = coin + cur_amount;
//                System.out.println("next = " + next);
                if (cur_amount <= amount - coin && !visited[next]) {
//              if (next <= amount && !visited[next]) {
                    //런타임 에러
                    // int 최대값 + cur_amount => 정수의 범위를 벗어나버렸다
                    // 2의 보수법 => min_value 가 됐다 => 오버플로우
                    // 굳이 최대형이 아니더라도 위험하다 ~ 제약조건

                    visited[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }
}
//클래스로도 만들어서 해보자

