import java.util.Scanner;

public class boj_2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if(start<A[i]) start = A[i]; // 최대 레슨 길이
            end += A[i]; // 모든 레슨의 총합
        }

        while (start <= end) {
            int m = (start + end) / 2;
            int sum = 0; // 레슨 합
            int count = 0; // 현재 사용한 블루레이 개수
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > m) { // 현재 블루레이에 담을수 없는 경우
                    count++; // 블루레이 추가
                    sum = 0; // 현재 블루레이에 저장할 수 없어 새로운 블루레이 사용
                }
                sum += A[i]; // 현재 블루레이에 레슨 추가
            }
            if (sum !=0) count++; // 마지막 블루레이 처리
            if (count > M) { // 필요한 블루레이 개수가 많으면
                start = m + 1; // 블루레이 크기를 키운다
            } else end = m - 1; // 블루레이 크기를 줄인다
        }
        System.out.println(start);
    }
}
