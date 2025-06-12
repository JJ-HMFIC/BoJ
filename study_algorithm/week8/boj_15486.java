package study_algorithm.week8;

import java.io.IOException;
import java.util.Scanner;

public class boj_15486 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 총 N일
        int[] T = new int[N + 2]; // 상담 기간
        int[] P = new int[N + 2]; // 수익
        int[] dp = new int[N + 2]; // dp[i] = i일부터의 최대 수익

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt(); // i일에 상담 걸리는 기간
            P[i] = sc.nextInt(); // i일에 상담하면 벌 수 있는 돈
        }

        // 역방향으로 계산
        for (int i = N; i >= 1; i--) {
            if (i + T[i] <= N + 1) {
                // 상담할 수 있다면: 지금 상담 vs 안 하고 다음 날
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);
            } else {
                // 상담 불가능: 다음 날과 동일
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]); // 1일부터 시작할 때 최대 수익
    }
}
