
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                tetromino(1, map[i][j], i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void tetromino(int cnt, int sum, int x, int y) {
        if (cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;


            // 1. ㅗ 모양 처리 (핵심 수정 부분)
            // 블록이 2개 모였을 때, 다음 블록(nx, ny)을 선택은 하되
            // 위치는 현재 위치(x, y)에 머물러서 제3의 블록을 찾게 함 (즉, T자 중심 유지)
            if (cnt == 2) {
                visited[nx][ny] =true;
                tetromino(cnt + 1, sum + map[nx][ny], x, y);
            }

            visited[nx][ny] = true;
            tetromino(cnt + 1, sum + map[nx][ny], nx, ny);
            visited[nx][ny] = false;
        }
    }
}
