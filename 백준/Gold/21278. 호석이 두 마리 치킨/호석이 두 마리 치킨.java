import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int k1, k2, N, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        min = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
//                if (i == j) continue;
                chicken(i, j);
            }
        }
        System.out.println(k1 + " " + k2 + " " + min * 2);
    }

    private static void chicken(int one, int two) {

        int[] distance = new int[N + 1];
        Arrays.fill(distance, 100000);
        distance[one] = 0;
        distance[two] = 0;

        Queue<Info> queue = new ArrayDeque<>();

        queue.add(new Info(one, 0));
        queue.add(new Info(two, 0));
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            int num = now.num;
            int dist = now.dist;

            if (dist > distance[num]) continue;
            
            for (int neighbor : list[num]) {
                if (dist + 1 < distance[neighbor]) {
                    distance[neighbor] = dist + 1;
                    queue.add(new Info(neighbor, dist + 1));
                }
            }
        }
        int tmp = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == 100000) return;
            tmp += distance[i];
        }
        if (tmp < min) {
            min = tmp;
            k1 = one;
            k2 = two;
        }

    }
}

class Info {
    int num;
    int dist;

    public Info(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}
