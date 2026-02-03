
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static List<Integer> answer;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//도시의 개수
        int M = Integer.parseInt(st.nextToken());//도로의 개수
        K = Integer.parseInt(st.nextToken());// 거리 정보
        int X = Integer.parseInt(st.nextToken());// 출발 도시 번호
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        bfs(X);
        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
//            Collections.sort(answer);
            answer.sort((o1, o2) -> o1 - o2);
            for (int num : answer) {
                System.out.println(num);
            }
        }

    }
    public static void bfs(int x) {
        Queue<City> queue = new ArrayDeque<>();
        visited[x] = true;
        queue.add(new City(x, 0));

        while (!queue.isEmpty()) {
            City now = queue.poll();
            if (now.dist == K) answer.add(now.cityNum);
            for (int nextCity : list[now.cityNum]) {
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.add(new City(nextCity, now.dist + 1));
                }
            }
        }

    }
    public static class City{
        int cityNum;
        int dist;

        public City(int cityNum, int dist) {
            this.cityNum = cityNum;
            this.dist = dist;
        }
    }
}
