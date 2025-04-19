import java.util.Scanner;

public class boj_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N]; // 합 배열
        for (int i = 0; i < N; i++) A[i] = sc.nextInt(); // 배열 입력받음

        for (int i = 1; i <N ; i++) {

            int insert_point = i;
            int insert_value = A[i];

            for (int j = i-1; j >=0 ; j--) {

                if (A[j] < A[i]) { // 나보다 작은수 바로 뒷자리에 삽입
                    insert_point = j + 1;
                    break;
                } // 삽입 정령 : 어느정도 정렬된 배열에 삽입하는 메커니즘, 따라서 바로 뒤에 삽입해도 문제없음

                if (j == 0) {
                    insert_point = 0;
                }
            } // 삽입할 위치 정하기

            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1]; // 한칸씩 뒤로 밀려나고

            }
            A[insert_point] = insert_value; // 자리에 삽입
        }
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) sum += S[i];
        System.out.println(sum);
    }
}
