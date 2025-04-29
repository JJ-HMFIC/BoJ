package study_algorithm.week3;

import java.util.Scanner;

public class boj_10870_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 2]; // N이 0일 수도 있으니까 크기를 N+2로 여유 있게

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
    }
}
