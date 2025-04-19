import java.util.Arrays;
import java.util.Scanner;

public class boj_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt(); // 찾아야 하는 수
            int start = 0 ;
            int end = A.length - 1;
            while (start <= end) { // 이진 탐색
                int midi = (start + end) / 2;
                int midV = A[midi];
                if (midV > target) {
                    end = midi - 1;
                } else if (midV < target) {
                    start = midi + 1;
                } else {
                    find = true;
                    break; // while 문 나오기
                }
            }
            if (find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
