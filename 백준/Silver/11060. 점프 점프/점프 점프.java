import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1]; // i번째 발판에 도착하기 위한 최소 점프 횟수
        Arrays.fill(dp, 1000);
        dp[1] = 0;

        for (int i = 1; i <= N; i++) {
            if (dp[i] == 1000) continue;
            int jumpD = arr[i];
            for (int j = 1; j <= jumpD; j++) {
                if (i + j <= N) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        if(dp[N]==1000) System.out.println(-1);
        else System.out.println(dp[N]);
    }
}
