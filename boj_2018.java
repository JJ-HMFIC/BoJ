import java.util.Scanner;

public class boj_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != N) {
            if (sum == N) {
                cnt++; // 경우의 수 늘리고
                end_index++; // 범위 증가
                sum += end_index; // 합 증가 -> 필연적으로 다음 턴에 start 줄임
            } else if (sum > N) {
                sum -= start_index; // 범위 줄이기 , 작은수 쳐내기
                start_index++; // 전진
            } else { // sum < N
                end_index++; // 범위 늘리기
                sum += end_index; // 범위 증가
            }
        }
        System.out.println(cnt);
    }
}
