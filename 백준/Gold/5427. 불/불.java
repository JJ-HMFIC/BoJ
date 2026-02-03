import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int h, w, startX, startY;
    static Deque<Info> startFire;
    static int[][] fires;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fires = new int[h][w];
            for (int[] row : fires) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            startFire = new ArrayDeque<>();
            for (int j = 0; j < h; j++) {
                String input = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = input.charAt(k);
                    if (map[j][k] == '@') {
                        startX = j;
                        startY = k;
                    }
                    if (map[j][k] == '*') {
                        startFire.add(new Info(j, k, 0));
                        fires[j][k] = 0;
                    }
                }
            }
            calFire();
            int result = bfs(startX, startY);
            if (result == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(result);
        }
    }

    static class Info {
        int x, y, dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static void calFire() {

        while (!startFire.isEmpty()) {
            Info now = startFire.poll();


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '#') continue;
                if (fires[nx][ny] != Integer.MAX_VALUE) continue;
                fires[nx][ny] = now.dist + 1;
                startFire.add(new Info(nx, ny, now.dist + 1));
            }
        }

    }

    static int bfs(int x, int y) {
        Deque<Info> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];
        visited[x][y] = true;
        queue.add(new Info(x, y, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if (now.x == 0 || now.y == 0 || now.x == h - 1 || now.y == w - 1) return now.dist + 1;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '#'||visited[nx][ny]) continue;
                if (fires[nx][ny] <= now.dist + 1) continue;

                visited[nx][ny] = true;
                queue.add(new Info(nx, ny, now.dist + 1));
            }
        }
        return -1;
    }

}
