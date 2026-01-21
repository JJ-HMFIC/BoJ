import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] names = new String[N];
        long answer = 0;
        Map<Integer, ArrayList<Integer>> goodFriends = new HashMap<>();

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
            int len = names[i].length();
            if (!goodFriends.containsKey(len)) {
                goodFriends.put(len, new ArrayList<>());
            }
            goodFriends.get(len).add(i);
        }

        for (int len : goodFriends.keySet()) {
            ArrayList<Integer> idx = goodFriends.get(len); // 같은 길이의 이름을 가진 학생들의 등수
            int left = 0;
            for (int right = 0; right < idx.size(); right++) {
                while (idx.get(right) - idx.get(left) > K) { // 등수가 K이하 차이일때까지
                    left++; // 왼쪽 포인터를 줄임
                } 
                answer += (right - left);
            }
        }
        System.out.println(answer);




    }
}
