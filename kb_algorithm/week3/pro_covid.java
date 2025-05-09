package kb_algorithm.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pro_covid {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int[] solution(String[][] places) {

        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) {
            char[][] grid = new char[5][5];

            for (int i = 0; i < 5; i++) {
                grid[i] = place[i].toCharArray();
            }
            int result = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (grid[i][j] == 'P') {
                        if (BFS(grid, i, j) == 0) {
                            result = 0;
                            break;
                        }
                    }
                }
                if (result == 0) break;
            }
            answer.add(result);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int BFS(char[][] grid, int i, int j) {
        Queue<Entry> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(new Entry(i, j, 0));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Entry top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (grid[x][y] == 'P' && dist != 0 && dist <= 2) return 0;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny] || grid[nx][ny] == 'X') continue;

                queue.offer(new Entry(nx, ny, dist + 1));
                visited[nx][ny] = true;
            }
        }
        return 1;
    }

    private class Entry {
        int x;
        int y;
        int distance;

        public Entry(int x, int y, int distance) {
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
}
