package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class pro_miro {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {

        char[][] grid = new char[maps.length][maps[0].length()];
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < maps.length; i++) {
            if (maps[i].contains("S")) {
                startX = i;
                startY = maps[i].indexOf('S');
            }
            grid[i] = maps[i].toCharArray();
        }
        Search toLever = BFS(grid, startX, startY, 'L');
        if (toLever.getDistance() == -1) return -1;
        Search toGoal = BFS(grid, toLever.getX(), toLever.getY(), 'E');
        if (toGoal.getDistance() == -1) return -1;

        return toLever.getDistance() + toGoal.getDistance();
    }

    public Search BFS(char[][] grid, int i, int j, char end) {

//        char[][] temp = new char[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];

//        for (int k = 0; k < grid.length; k++) {
//            temp[k] = grid[k].clone();
//        } // 배열 복사

        Queue<Search> queue = new LinkedList<>();
        queue.offer(new Search(i, j, 0));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Search top = queue.poll();

            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (grid[x][y] == end) {
                return new Search(x, y, dist);
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;

                if (grid[nx][ny] != 'X' && !visited[nx][ny]) {
                    queue.offer(new Search(nx, ny, dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return new Search(-1, -1, -1);
    }
}

class Search {
    int x;
    int y;
    int distance;

    public Search(int x, int y, int distance) {
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
