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
        // 전부 0으로 초기화 할 시
        // 플로이드-워셜 공식을 쓸 때 최단 거리가 0+0= 0 으로 망가지게 된다
        // 대각선 i=i 일때만 0으로 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a][b] = 1;
            friend[b][a] = 1;
        }// 인접 행렬 만들기

        //플로이드- 워셜 사용
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
            } // i에서 각각 정점까지의 거리의 합
            if (sum < answer) {
                answer = sum;
                idx = i; // 가장 합이 작은 정점의 인데스를 반환해야 함
            }
        }
        System.out.println(idx);
    }

}
