import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int right = 0;
        int left = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }
        int answer = right;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int current = mid;

            for (int daily : arr) {
                if (current < daily) {
                    // 인출 금액이 하루 사용량보다 적으면
                    count++;
                    current = mid; // 인출 한번 더 하고
                }
                current -= daily; // 인출 차감한다.
            }

            if (count <= M) { // 인출 횟수가 목표였던 M보다 작으면
                answer = mid;
                right = mid - 1; // 더 작은 값으로도 가능한 지 테스트
            } else {
                left = mid + 1; // 횟수가 많았으면 더 큰 값으로 테스트 
            }
        }
        System.out.println(answer);
    }
}
