
import java.io.*;
import java.util.*;

public class Main {
    static int N, K, max, len;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        len = String.valueOf(N).length();
        K = Integer.parseInt(st.nextToken());
        max = 0;
        arr = new int[K];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        dfs(0);
        System.out.println(max);
    }
    // current : 현재 숫자
    private static void dfs(int current) {
        if (current>N) return;

        max = Math.max(max, current);

        for (int i = 0; i < K; i++) {
            dfs(current * 10 + arr[i]);
        }
    }
}
