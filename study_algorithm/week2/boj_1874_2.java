package study_algorithm.week2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class boj_1874_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer bf = new StringBuffer(); // 출력 버퍼

        int N = sc.nextInt(); // 수열의 길이

        Deque<Integer> stack = new ArrayDeque<>(); // 스택 선언
        int start = 0; // 초기 값 0 -> 지금까지 push 한 가장 큰 수를 기억함

        while (N-- > 0) {
            int value = sc.nextInt(); // 수열의 현재 값 입력받기

            if (value > start) { // 현재 값보다 가장 큰 수가 작으면
                for (int i = start+1; i <= value; i++) {
                    // 해당 값보다 작으면 그 값까지 푸쉬 연산
                    stack.push(i);
                    bf.append('+').append('\n');
                }
                start = value; // 현재까지 push한 수 중 가장 큰 값 업데이트
            } else if (stack.isEmpty() || stack.peek() != value) {
                System.out.println("NO");
                return;  // 스택이 비었거나, 현재 수열 값과 다르면 수열 생성 불가
                // 팝 했을 때 기준이라 꼭대기가 해당 값과 다르면 안됌
            }
            stack.pop(); // 값 일치 시 pop
            bf.append('-').append('\n'); // pop 연산 기록
        }

        System.out.println(bf);
    }
}
