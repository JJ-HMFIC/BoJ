import java.util.Scanner;

public class boj_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long ans = 0;
        while (start <= end) {
            long m = (start + end) / 2;
            long cnt = 0;
            // 1햅부터 N행까지
            for (int i = 1; i <= N; i++) cnt += Math.min(m / i, N); // 중앙값보다 작거나 같은 수 세기
            if (cnt < K) { // k번째 수가 중앙값보다 크면
                start = m + 1; // 큰쪽에서 이진탐색
            } else { // 아니면
                ans = m; // 현재 단계에서 이진탐색 저장하고
                end = m - 1; // 작은쪽 이진탐색
            }
        }
        System.out.println(ans);
    }
}
