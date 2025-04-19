import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_11003 {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken()); // 하나씩 입력 받고
            // 새로 들어올 값보다 큰 값이 있다면 pop한다.
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) mydeque.removeLast();
            mydeque.addLast(new Node(now,i));
            // L의 범위 밖의 초반 인덱스 제거
            if (mydeque.getFirst().index <= i - L) mydeque.removeFirst();
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        br.close();
    }

    static class Node{
        public int value;
        public int index;
        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
