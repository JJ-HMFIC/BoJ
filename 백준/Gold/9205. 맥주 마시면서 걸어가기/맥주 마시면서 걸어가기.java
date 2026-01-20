import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static Grid[] grids;
    static int goalX, goalY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            grids = new Grid[n + 2];
            StringTokenizer st ;
            for (int j = 0; j < n + 2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grids[j] = new Grid(x, y, j);
            }

            visited = new boolean[n + 2];
            goalX = grids[grids.length - 1].x;
            goalY = grids[grids.length - 1].y;
            System.out.println(bfs(grids[0].x, grids[0].y));

        }
    }

    public static String bfs(int x, int y) {
        Queue<Grid> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.add(new Grid(x, y,0));

        while (!queue.isEmpty()) {
            Grid now = queue.poll();
            if(now.x == goalX && now.y == goalY) return "happy";
            for (Grid next : grids) {
                if (distance(now.x, now.y, next.x, next.y) && !visited[next.idx]) {
                    visited[next.idx] = true;
                    queue.add(next);
                }
            }
        }
        return "sad";
    }

    public static boolean distance(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2) <= 1000);
    }

    static class Grid {
        int x,y,idx;

        public Grid(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
