import java.util.Scanner;

public class boj_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            A[i] = i; // 배열 자기 자신으로 초기화
        }
        for (int i = 2; i <= Math.sqrt(N); i++) { //제곱근 까지 수행
            if (A[i] == 0) continue;  // 이미 지워졌으면 패스
            for (int j = i+i; j <= N; j+=i) {
                // j 는 i 의 배수 ~ N 이하에서 i의 배수(=j)들은 소수가 아님(j로 나누어지기에)
                A[j] = 0; // j는 그래서 소수가 아님
            }
        }
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) System.out.println(A[i]); // 살아남은 소수들 리턴
        }
    }
}
