import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1744 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음의 수 저장

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        // 양수 우선순위 큐
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        // 음수 우선순위 큐
        int one = 0; // 1의 개수
        int zero = 0; // 0의 개수
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
        }// 수열이 1,0, 음수, 양수를 구별하여 넣기
        int sum = 0;
        while (plusPq.size()>1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        } // 양수끼리 묶고 곱하기
        if (!plusPq.isEmpty()) sum += plusPq.remove();
        // 한개남았을때 그냥 더함
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        } // 음수끼리 묶고 더하기(양수가 되니까)
        if (!minusPq.isEmpty()) {
            //음수가 하나 남는다면
            if (zero==0) {
                // 근데 0이 하나도 없다면
                sum += minusPq.remove();
            }// 그냥 음수 더하기 -> 0이 있다면 더하지 않을 것임
            // 왜냐면 0이랑 음수랑 곱해서 0으로 만들거기 때문에
            // 0이 몇개 있든 0은 다 더할거기때문에 합에 영향을 주지 않음
        }
        sum += one; // 1만큼 더하기
        System.out.println(sum);


    }
}
