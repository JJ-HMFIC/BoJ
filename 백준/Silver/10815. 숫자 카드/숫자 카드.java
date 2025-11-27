
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        int[] cards = new int[N];
        Set<Integer> hashSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) cards[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) hashSet.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int check = Integer.parseInt(st.nextToken());
            if(hashSet.contains(check)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
