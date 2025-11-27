import java.util.*;

public class Main {
    static Set<String> set;
    static int n, k;
    static int[] arr, result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        result = new int[k];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        set = new HashSet<>();

        perm(0);
        System.out.println(set.size());
    }

    private static void perm(int cnt) {
        if (cnt == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(result[i]);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            result[cnt] = arr[i];
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
