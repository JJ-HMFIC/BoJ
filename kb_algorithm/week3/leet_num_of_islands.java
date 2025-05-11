package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class leet_num_of_islands {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int m = grid.length; // 가로
        int n = grid[0].length; //세로
        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    BFS(grid, i, j); //각 좌표에 대해 BFS 수행 => 섬 어디까지 인지 찾기
                    answer++;
                }
            }
        }

        return answer;
    }

    public void BFS(char[][] grid, int i, int j) {
        Queue<Entry> queue = new LinkedList<>();
        if (grid[i][j] == '1') {
            queue.offer(new Entry(i, j)); // 큐에 넣고
            grid[i][j] = '0';
            // 방문 처리 => 방문처리를 0으로 하여
            // 다음에 방문할 때 걸리지 않으며, 동시에 새로 변수를 만들 필요가 없음

            while (!queue.isEmpty()) {
                Entry top = queue.poll();
                int x = top.getX();
                int y = top.getY(); // 큐에서 좌표 꺼내기

                for (int k = 0; k < 4; k++) {

                    int nx = x + dx[k];
                    int ny = y + dy[k]; // 주변 좌표 탐색

                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
                    // 범위를 벗어나면 패스 , 예외 처리

                    if (grid[nx][ny] == '1') {
                        queue.offer(new Entry(nx, ny)); // 주변이 육지면 큐에 넣고 방문 처리
                        grid[nx][ny] = '0';
                    }
                }
            }
        }
    }
    private class Entry { // 좌표 클래스
        int x;
        int y;

        public Entry(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


