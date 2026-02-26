
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int dasom = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dasom = sc.nextInt();
            } else {
                pq.add(sc.nextInt());
            }
        }
        int count = 0;

        while (!pq.isEmpty()) {
            int top = pq.poll();
            if (dasom > top) break;

            dasom ++;
            count++;
            top--;
            pq.add(top);
        }
        System.out.println(count);
    }
}
