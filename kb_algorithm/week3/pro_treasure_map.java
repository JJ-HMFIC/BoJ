package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class pro_treasure_map {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dx2 = {0, 0, 2, -2};
    static int[] dy2 = {2, -2, 0, 0};

    public int solution(int n, int m, int[][] hole) {
        int[][] map = new int[n + 1][m + 1];
        for (int[] idx : hole) {
            int x = idx[0];
            int y = idx[1];
            map[x][y] = 1; // 구멍은 1
        }
//        for (int i = 0; i < n; i++) {
//            map[i][0] = 1;
//        }
//        for (int i = 0; i < m; i++) {
//            map[0][i] = 1;
//        }
        int result = BFS(map, n, m);
        return result;
    }

    private int BFS(int[][] map, int n, int m) {
        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(1, 1, 0, false));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            State top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int time = top.getTime();
            boolean used = top.isUsed();

            if (x == n && y == m) return time;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if (visited[nx][ny][used ? 1 : 0]) continue;
                if (map[nx][ny] == 1) continue;

                visited[nx][ny][used ? 1 : 0] = true;
                queue.offer(new State(nx, ny, time + 1, used));
            }
            if (!used) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx2[i];
                    int ny = y + dy2[i];


                    if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                    if(map[nx][ny] == 1) continue; // 이거 안해서 틀렸음
                    if (visited[nx][ny][1]) continue;

                    visited[nx][ny][1] = true;
                    queue.offer(new State(nx, ny, time + 1, true));
                }
            }


        }

        return -1;
    }
}

class State {
    int x;
    int y;
    int time;
    boolean used;

    public State(int x, int y, int time, boolean used) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.used = used;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }

    public boolean isUsed() {
        return used;
    }
}
