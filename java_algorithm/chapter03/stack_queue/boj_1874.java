package java_algorithm.chapter03;

import java.util.Scanner;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        StringBuffer bf = new StringBuffer();  // 출력을 위한 버퍼
        int num = 1; // 스택 시작
        boolean result = true;

        for (int i = 0; i < A.length; i++) {
            int now = A[i]; // 수열의 값
            if (now >= num) {
                while (now >= num) { // 같아질때 까지 스택에 쌓기
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop(); // 수열의 값 꺼내기
                bf.append("-\n");
            } else { //
                int n = stack.pop(); // 수열의 값보다 스택값이 커서 뺏는데
                if (n > now) { // 스택 값이 수열보다 크면 게임 끝
                    // 수열의 값(3) < 스택값(5) 인데 스택값을 빼야 수열의 값 뺄수 있음
                    System.out.println("NO");
                    result = false;
                    break;
                } else bf.append("-\n");
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
