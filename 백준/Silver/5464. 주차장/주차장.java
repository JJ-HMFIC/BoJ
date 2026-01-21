import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] fare = new int[N + 1];
        int[] weight = new int[M + 1];
        int[] carLocation = new int[M + 1];
        Queue<Integer> wait = new ArrayDeque<>();
        PriorityQueue<Integer> emptySpots = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            fare[i] = Integer.parseInt(br.readLine());
            emptySpots.add(i);
        }
        for (int i = 1; i <= M; i++) weight[i] = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < 2 * M; i++) {
            int car = Integer.parseInt(br.readLine());
            if (car > 0) {
                if (emptySpots.isEmpty()) {
                    wait.add(car);
                } else {
                    int spot = emptySpots.poll();
                    carLocation[car] = spot;
                    answer += fare[spot] * weight[car];
                }
            } else {
                int spot = carLocation[-car];
                if (!wait.isEmpty()) {
                    int next = wait.poll();
                    carLocation[next] = spot;
                    answer += fare[spot] * weight[next];
                } else {
                    emptySpots.add(spot);
                }
            }
        }
        System.out.println(answer);
    }
}
