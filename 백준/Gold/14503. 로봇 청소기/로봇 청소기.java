import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int answer, N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        answer = 1;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(x, y, dir);
        System.out.println(answer);
    }

    private static void clean(int x, int y, int dir) {
        arr[x][y] = -1; // 청소하기

        for (int i = 0; i < 4; i++) { // 반시계 4번
            dir = (dir + 3) % 4; // 반시계 90도 회전
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (arr[nx][ny] == 0) { // 회전해서 청소가 안되어 있으면
                    answer++;
                    clean(nx, ny, dir); // 청소하기 수행
                    return;
                }
            }
        }
        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];

        if (bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) {
            clean(bx, by, dir); // 방향은 유지해야 함
        }
    }
}
