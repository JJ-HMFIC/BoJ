package study_algorithm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1389 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] friend;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friend = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                friend[i][j] = (i == j) ? 0 : 1000001;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    friend[S][E] = Math.min(friend[S][E], friend[S][K] + friend[K][E]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += friend[i][j];
            }
            if (sum < answer) {
                answer = sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }

}
