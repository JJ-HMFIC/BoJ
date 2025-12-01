import java.io.*;
import java.util.*;

public class Main {
    static int[] price, count, selCount;
    static String[] book;
    static int N, minPrice;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        count = new int[26];
        selCount = new int[26];
        for (int i = 0; i < word.length(); i++) count[word.charAt(i) - 'A']++;

        N = Integer.parseInt(br.readLine());
        price = new int[N];
        book = new String[N];
        visited = new boolean[N];
        minPrice = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken());
            book[i] = st.nextToken();
        }
        dfs(0, 0);
        if(minPrice==Integer.MAX_VALUE) minPrice = -1;

        System.out.println(minPrice);
    }

    private static void dfs(int idx, int sum) {
        if (sum >= minPrice) return;
        if (idx == N) {
            if (check()) minPrice = Math.min(minPrice, sum);
            return;
        }
        for (int i = 0; i < book[idx].length(); i++) selCount[book[idx].charAt(i) - 'A']++;
        dfs(idx + 1, sum + price[idx]);
        for (int i = 0; i < book[idx].length(); i++) selCount[book[idx].charAt(i) - 'A']--;
        dfs(idx + 1, sum);
    }

    private static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (count[i] > selCount[i]) return false;
        }
        return true;
    }
}
