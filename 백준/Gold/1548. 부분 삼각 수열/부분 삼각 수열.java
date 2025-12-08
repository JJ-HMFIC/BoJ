
import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N;
    static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if (N <= 2) {
            System.out.println(N);
            return;
        }
        maxLen = 2;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 2; j < N; j++) {
                if (arr[i] + arr[i + 1] > arr[j]) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else break;
            }
        }
        System.out.println(maxLen);
    }
}
