package kb_algorithm.week5;

import java.util.*;

class pro_queue {
    public long getSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> queueA = new ArrayDeque<>();
        Deque<Integer> queueB = new ArrayDeque<>();

        long sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            queueA.add(queue1[i]);
            sum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            queueB.add(queue2[i]);
            sum += queue2[i];
        } // 초기화
        if (sum % 2 == 1) return -1; // 얼리 리턴 조건

        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2); // 두 큐의 합
        int count = 0;

        while (sum1 != sum2) {
            if (count > 2000000) return -1;
            if (sum1 > sum2) {
                int tmp = queueA.poll();
                sum1 -= tmp;
                sum2 += tmp;
                queueB.add(tmp);
            } else if (sum1 < sum2) {
                int tmp = queueB.poll();
                sum2 -= tmp;
                sum1 += tmp;
                queueA.add(tmp);
            } else return count;
            count++;
        }
        return count;
    }
}