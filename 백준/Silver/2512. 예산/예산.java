import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long budget = Long.parseLong(br.readLine());
        long left = 0;
        long right = arr[N - 1];
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int money : arr) {
                if (money > mid) sum += mid;
                else sum += money;
            }

            if (sum <= budget) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
