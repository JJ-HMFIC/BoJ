package study_algorithm.week2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) queue.offer(i); // 큐에 일단 담기
        System.out.print('<'); // 입출력 요구 조건 맞추기 1
        while (!queue.isEmpty()) { // 큐가 빌 때까지
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll()); // k-1개는 뺏다가 뒤에 넣고
            }
            System.out.print(queue.poll()); // k 번째를 꺼내서 출력
            if(!queue.isEmpty()) {
                System.out.print(", "); // 입출력 요구조건 맞추기 2 , 마지막에는 ',' 안찍기
            }
        }
        System.out.print('>'); // 입출력 요구조건 3
    }
}
