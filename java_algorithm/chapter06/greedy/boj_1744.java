import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1744 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음의 수 저장

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            if (data > 1) {
                plusPq.add(data);
            } else if (data ==1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }
        int sum = 0;
        while (plusPq.size()>1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }
        if (!plusPq.isEmpty()) sum += plusPq.remove(); // 한개남았을때 그냥 더함
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        }
        if (!minusPq.isEmpty()) {
            if (zero==0) {
                sum += minusPq.remove(); // 음수랑 0이랑 곱할게 없다면 그냥 음수를 더함
            }
        }
        sum += one;
        System.out.println(sum);


    }
}
