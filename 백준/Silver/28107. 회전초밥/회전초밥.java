
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 손님 수
        int M = Integer.parseInt(st.nextToken()); // 초밥 수

        List<Queue<Integer>> list = new ArrayList<>();

        for (int i = 0; i <=200000; i++) {
            list.add(new ArrayDeque<>());
        }

        for (int customerID = 0; customerID < N; customerID++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 주문 개수
            for (int j = 0; j < k; j++) {
                int sushiType = Integer.parseInt(st.nextToken());
                list.get(sushiType).add(customerID);
            }
        }
        int[] cnt = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int currentSushi = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = list.get(currentSushi);
            if (!queue.isEmpty()) {
                cnt[queue.poll()]++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(cnt[i]+" ");
        }


    }
}
