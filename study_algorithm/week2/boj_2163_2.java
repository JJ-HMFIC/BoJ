package study_algorithm.week2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class boj_2163_2 {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) queue.offer(i);
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
        // 스택, 큐, 덱을 쓸 땐 ArrayDeque 가 기본 선택
        //
        // 내부에 동적 배열을 가지고 있음
        //
        // 요소를 앞뒤로 넣고 빼는 데 최적화되어 있음 (큐/스택 역할)
        //
        // 배열 크기 초과 시 자동으로 확장됨

    }
}
