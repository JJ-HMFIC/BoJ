import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;
    static int[][] visited;
    static int x, y, N, H, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr[i] = line.toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(findE(x, y));
    }

    private static int findE(int x, int y) {
        Queue<Info> queue = new ArrayDeque<>();
        visited[x][y] = H;
        queue.add(new Info(x, y, H, 0, 0));

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Info top = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = top.x + dx[i];
                int ny = top.y + dy[i];
                if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;

                int nextUm = top.um;
                int nextHp = top.hp;
                if (arr[nx][ny] == 'E') {
                    min = Math.min(min, top.dist + 1);
                }
                if (arr[nx][ny] == 'U') nextUm = D;

                if (nextUm > 0) nextUm--; // 다음 행선지에 대한 정보이므로
                else nextHp--;
                

                if (nextHp == 0) continue;
                if (visited[nx][ny] < nextHp + nextUm) { // 현재 경우의 수가 더 체력이 많으면(최적해)
                    visited[nx][ny] = nextHp + nextUm; // 업데이트
                    queue.add(new Info(nx, ny, nextHp, nextUm, top.dist + 1));
                }
            }
        }
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    }

    static class Info {
        int x;
        int y;
        int hp;
        int um;
        int dist;

        public Info(int x, int y, int hp, int um, int dist) {
            this.x = x;
            this.y = y;
            this.hp = hp;
            this.um = um;
            this.dist = dist;
        }
    }
}


