import java.util.Scanner;

public class boj_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
        dp[0]=0;
        dp[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            if(i==2) dp[i] = arr[1] + arr[2];
            else if (i==3) dp[i] = Math.max(arr[1], arr[2]) + arr[3];
            else dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[N]);

    }
}
