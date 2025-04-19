import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if (S[1] == E[1]) { // 종료시간이 같으면
                    return S[0] - E[0]; // 출발시간이 짧은거로
                }
                return S[1] - E[1]; // 종료시간이 짧은 회의로 정렬
            }
        });
        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if(A[i][0]>=end){ // 겹치지 않는 다음 회의가 나올 경우
                end = A[i][1]; // 종료시간 업데이트
                count++;
            }
        }
        System.out.println(count);
    }
}
