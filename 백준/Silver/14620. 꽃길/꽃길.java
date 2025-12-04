
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] land;
    static int min, N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        seed(0, 0);
        System.out.println(min);

    }

    private static void seed(int cnt, int sum) {
        if (cnt == 3) {
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPossible(i, j)) {
                    int tmp = land[i][j];
                    visited[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        tmp += land[nx][ny];
                        visited[nx][ny] = true;
                    }

                    seed(cnt + 1, sum + tmp);

                    visited[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        visited[nx][ny] = false;
                    }
                }
            }

        }
    }

    private static boolean isPossible(int x, int y) {
        if(visited[x][y]) return false;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return false;
            }

        }
        return true;
    }
}
