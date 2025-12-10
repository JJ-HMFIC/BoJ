
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer, N, M;
    static int[][] map;
    static List<Grid> chicken,home;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chicken.add(new Grid(i, j));
                }
                if (map[i][j] == 1) {
                    home.add(new Grid(i, j));
                }
            }
        }
        answer = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        select(0,0);
        System.out.println(answer);
    }

    private static void select(int start,int cnt) {
        if (cnt == M) {
            cal();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            select(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    private static void cal() {
        int result = 0;
        for (Grid person : home) {
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (visited[i]) {
                    Grid tmp = chicken.get(i);
                    minDist = Math.min(minDist, Math.abs(person.x - tmp.x) + Math.abs(person.y - tmp.y));
                }
            }
            result += minDist;
        }
        answer = Math.min(answer, result);
    }
}

class Grid {
    int x;
    int y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
