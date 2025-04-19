import java.util.Scanner;

public class boj_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > max) max = arr[i];
            sum += arr[i];
        }
        System.out.println((((double) sum / max) * 100.0) / N);

    }
}
