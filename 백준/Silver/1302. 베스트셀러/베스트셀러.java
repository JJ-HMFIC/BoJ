import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
            max = Math.max(map.get(word), max);

        }
        TreeSet<String> set = new TreeSet<>();
        for (String word : map.keySet()) {
            int num = map.get(word);
            if (num == max) set.add(word);
        }
        System.out.println(set.first());
    }
}
