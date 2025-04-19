import java.util.Scanner;

public class boj_1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] A = new long[10000001];
        for (int i = 2; i < A.length; i++) A[i] = i;
        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == 0) continue;
            for (int j = i+i; j < A.length ; j+=i) {
                A[j] = 0;
            }
        }
        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (A[i] != 0) { // 소수라면
                long temp = A[i];
                while ((double) A[i] <= (double) max / (double) temp) { // 2제곱부터 시작
                    if ((double) A[i] >= (double) min / (double) temp) { // min~max 사이라면
                        cnt++; // 개수 올림
                    }
                    temp *= A[i]; // 다음 제곱으로
                }
            }
        }
        System.out.println(cnt);
    }
}
