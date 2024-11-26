import java.io.*;
import java.util.Stack;

public class boj_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N]; // 입력 수열 배열
        int[] Ans = new int[N]; // 출력 정답 배열
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(str[i]);
        Stack<Integer> stack = new Stack<>(); // 인덱스를 담는 스택
        stack.push(0); // 처음은 무조건 넣어야됌
        // 오큰수를 만나면 스택에 있는 모든 인덱스 pop하고 -> 그 인덱스에 위치한 정답 배열에 오큰수(peek)를 넣음
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                Ans[stack.pop()] = A[i];
            }// 인덱스 다빼서 오큰수 설정함 -> 그럼 스택이 비어있음
            stack.push(i);
        }
        while (!stack.isEmpty()) Ans[stack.pop()] = -1; // 한번 다 돌렷는데 스택에 남아있다면 오큰수가 없는 것 = -1
        // 문제의 핵심 : 인덱스 순서대로 오큰수를 채우려고 하지 않음 = 스택 활용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
           bw.write(Ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
