package boj_test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798 {
    static int[] cards;
    static int N,M;
    static int maxSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 배열의 수
        M = Integer.parseInt(st.nextToken()); // 블랙잭 숫자
        cards = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) cards[i] = Integer.parseInt(st.nextToken());
        dfs(0, 0, 0);
        System.out.println(maxSum);
    }

    static void dfs(int index, int count, int sum) {
        // index = 현재 탐색중인 카드의 인덱스
        // count = 현재까지 선택한 카드의 개수
        // sum = 현재 선택한 카드의 합
        if (count == 3) {
            if (sum <= M) {
                maxSum = Math.max(maxSum, sum); // 기존 합과 비교하여 업데이트
            }
            return;
        }
        if (index >= N) {
            return; // 모든 카드 탐색하면 리턴
        }
        dfs(index + 1, count + 1, sum + cards[index]); // 현재 카드 탐색
        dfs(index + 1, count, sum); // 현재 카드 선택 안함
    }
}
