package study_algorithm.week4;

import java.util.Scanner;

public class boj_2018_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 1; // 자기 자신은 포함이니깐

        int start = 1;
        int end = 1;
        int sum = 1; // 처음은 1이니까
        // 1~~~N 까지 투 포인터 활용
        // 두 포인터 모두 맨 앞에다 놓고 시작
        while (end != N) {
            if (sum == N) {
                count++;
                end++;
                sum += end;
                // 합과 같으면 카운트 올리고 end 포인터 전진
                // sum 업데이트
            } else if (sum < N) {
                end++;
                sum += end;
                // 합이 목표보다 작으면
                // end 전진 => sum을 더 크게 만들기
            } else {
                sum -= start;
                start++;
                // 목표보다 크면 sum을 작게 만들기
                // start를 전진 => 기존의 가장 작은값이 빠진다
            }

        }
        System.out.println(count);

    }
}
