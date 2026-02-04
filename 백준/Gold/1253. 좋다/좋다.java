import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        //---- 수정해야 함

        for (int i = 0; i < N; i++) {
            int j = 0;
            int k = N - 1;
            int good = arr[i];
            while (j < k) {
                if (j == i) {
                    j++;
                    continue;
                }
                if (k == i) {
                    k--;
                    continue;
                }
                if (arr[j] + arr[k] == good) {
                    result++;
                    break;
                }
                else if (arr[j]+arr[k]>good) k--;
                else j++;
            }
        }
        System.out.println(result);
    }
}
