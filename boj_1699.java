import java.util.Scanner;

public class boj_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100001];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2 ; i <=N ; i++) {
            dp[i] = i;
            for (int j = 1; j*j<=i ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1 );
            }
        }
        System.out.println(dp[N]);
    }
}
