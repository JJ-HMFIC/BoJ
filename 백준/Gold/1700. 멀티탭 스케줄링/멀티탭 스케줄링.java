
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sequence = new int[K];
        for (int i = 0; i < K; i++) sequence[i] = Integer.parseInt(st.nextToken());

        Set<Integer> plugs = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int cur = sequence[i];

            if(plugs.contains(cur)) continue;

            if(plugs.size()<N) {
                plugs.add(cur);
                continue;
            }
            int targetIdx = -1;
            int plugOut = -1;
            for (int plug : plugs) {
                int nextIdx = K + 1;
                for (int j = i + 1; j < K; j++) {
                    if (plug == sequence[j]) {
                        nextIdx = j;
                        break;
                    }
                }
                if (nextIdx > targetIdx) {
                    targetIdx = nextIdx;
                    plugOut = plug;
                }
            }
            plugs.remove(plugOut);
            plugs.add(cur);
            answer++;
        }
        System.out.println(answer);
    }
}
