package study_algorithm.week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class boj_17298_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] A = new int[N]; // 입력 수열 배열
        int[] Ans = new int[N]; // 출력 정답 배열

        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(str[i]);// 입력 배열로 담기

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스를 담는 스택(deque 구현)
        stack.push(0); // 처음은 무조건 넣어야됌, 스택에 넣는 건 인덱스
        // 오큰수를 만나면 스택에 있는 모든 인덱스 pop하고
        // -> 그 인덱스에 위치한 정답 배열에 오큰수(peek)를 넣음

        for (int i = 1; i < N; i++) { // 인덱스 0을 넣었으니 인덱스 1부터 조사
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                // 스택의 꼭대기 값보다 입력 값이 더 크다면 -> 오큰 수
                Ans[stack.pop()] = A[i];
                // 해당 인덱스의 오큰 수는 입력 값
                // => 현재 인덱스 뒤에 있는 값중 가장 빨리 나오는 큰 값
            }// 인덱스 다빼서 오큰수 설정함 -> 그럼 스택이 비어있음
            stack.push(i); // 인덱스를 넣어서 다음 오큰 수 찾기
        }
        while (!stack.isEmpty()) Ans[stack.pop()] = -1;
        // 한번 다 돌렷는데 스택에 남아있다면 오큰수가 없는 것 = -1
        // 문제의 핵심 : 인덱스 순서대로 오큰수를 채우려고 하지 않음 = 스택 활용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
           bw.write(Ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
