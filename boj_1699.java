import java.util.Scanner;

public class boj_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100001];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2 ; i <=N ; i++) {
            dp[i] = i; // 자연수 n 은 최대 1의 n개의 합  n = 1+1+...1 로 표현 가능 => 초기화
            for (int j = 1; j*j<=i ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1 ); // 점화식
            }
        }
        System.out.println(dp[N]);
    }
}
