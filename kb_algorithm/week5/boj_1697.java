package kb_algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_1697 {
    static int[] dx = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        if (N == M) {
            System.out.println(0);
            return;
        } // 같으면 끝
        System.out.println(BFS1(N, M));
    }

    private static int BFS1(int start, int end) {
        boolean[] visited = new boolean[100001];
        Deque<Location> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(new Location(start, 0));

        while (!queue.isEmpty()) {
            Location top = queue.poll();
            int where = top.getX();
            int time = top.getTime();

            if (where == end) return time;

            for (int add : dx) {
                int nx;
                if (add == 2) {
                    nx = 2 * where;
                } else {
                    nx = add + where;
                }
                if(nx>100000 || nx<0 || visited[nx]) continue;

                visited[nx] = true;
                queue.offer(new Location(nx, time + 1));
            }

        }
        return 0;
    }

    public static class Location {
        int x;
        int time;

        public Location(int x, int time) {
            this.x = x;
            this.time = time;
        }

        public int getX() {
            return x;
        }

        public int getTime() {
            return time;
        }
    }
}
