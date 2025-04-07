import java.util.Scanner;

public class boj_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1]; // 입력 점수 배열
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
        dp[0] = 0;

        dp[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            if(i==2) dp[i] = arr[1] + arr[2];
            // 계단이 2개 밖에 없으면 최대는 두 계당 모두 밟는 것
            else if (i==3) dp[i] = Math.max(arr[1], arr[2]) + arr[3];
            // 계단이 3개면
            // 1 + 3 or 2+3 의 경우의 수 밖에 없다
            // 마지막 계단 3은 밟아야 하므로 + 1,2,3 모두 밟을 순 없음
            else dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
            //
        }

        System.out.println(dp[N]);

    }
}
