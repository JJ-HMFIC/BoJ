package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class nossi_ambulance {
    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int m;
    static int n;

    static boolean[][] visited;

    public int solution(int[][] city) {
        m = city.length;
        n = city[0].length;

        visited = new boolean[m][n];

        if (city[0][0] == 1 || city[m - 1][n - 1] == 1) return -1;

        return BFS(city, 0, 0);
    }

    public int BFS(int[][] city, int i, int j) {
        Queue<Move> queue = new LinkedList<>();

        queue.offer(new Move(i, j, 1));
//        city[i][j] = 1;
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Move top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (x == m - 1 && y == n - 1) return dist;

            for (int k = 0; k < 8; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if (city[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.offer(new Move(nx, ny, dist + 1));
//                    city[nx][ny] = 1;
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}

class Move {
    int x;
    int y;
    int distance;

    public Move(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getDistance() {
        return distance;
    }
}
