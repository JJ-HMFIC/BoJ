import java.util.*;

public class Main {
    static int N, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        min = Integer.MAX_VALUE;

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }

}