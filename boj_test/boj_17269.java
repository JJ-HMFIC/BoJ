package boj_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_17269 {
    static int[] vals = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        StringBuilder combined = new StringBuilder();

        int minlen = Math.min(N, M);
        for (int i = 0; i < minlen; i++) {
            combined.append(str1.charAt(i)).append(str2.charAt(i));
        }
        if (N > M) {
            combined.append(str1.substring(minlen));
        } else {
            combined.append(str2.substring(minlen));
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < combined.length(); i++) {
            int index = combined.charAt(i) - 'A';
            numbers.add(vals[index]);
        }
        while (numbers.size() > 2) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i = 0; i < numbers.size() -1; i++) {
                int result = (numbers.get(i) + numbers.get(i + 1)) % 10;
                next.add(result);
            }
            numbers = next;
        }
        int fin = numbers.get(0) * 10 + numbers.get(1);
        System.out.println(fin +"%");

    }
}
