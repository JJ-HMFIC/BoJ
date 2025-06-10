package study_algorithm.week8;

import java.util.Scanner;

public class boj_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1 || N == 2) {
            System.out.println(N);
            return;
        }

        long[] Dp = new long[N + 1];


        Dp[1] = 1;
        Dp[2] = 2;

        for (int i = 3; i < N + 1; i++) {
            Dp[i] = (Dp[i - 1] + Dp[i - 2]) % 10007;
        }

        System.out.println(Dp[N]);
    }
}
