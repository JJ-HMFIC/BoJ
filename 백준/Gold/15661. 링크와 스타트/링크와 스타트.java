
import java.io.*;
import java.util.*;

public class Main {
    static int N, min;
    static int[][] arr;
    //    static List<Integer> idxStart, idxLink;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        min = Integer.MAX_VALUE;
        visited = new boolean[N];
//        idxStart = new ArrayList<>();
//        idxLink = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(0);
        System.out.println(min);
    }

    private static void subset(int idx) {
        if (idx == N) {
            //int sum1 = listSum(idxStart);
//            for (int i = 0; i < N; i++) {
//                if(!idxStart.contains(Integer.valueOf(i))) idxLink.add(i);
//            }
//            int sum2 = listSum(idxLink);
//            min = Math.min(min, Math.abs(sum1 - sum2));
//            idxLink.clear();
            int sum = result();
            min = Math.min(min, sum);
            return;
        }
        //idxStart.add(idx);
        visited[idx] = true;
        subset(idx + 1);

        //idxStart.remove(Integer.valueOf(idx));
        visited[idx] = false;
        subset(idx + 1);
    }

    private static int listSum(List<Integer> list) {
        int sum = 0;
        for (int idx1 : list) {
            for (int idx2 : list) {
                sum += arr[idx1][idx2];
            }
        }
        return sum;
    }

    private static int result() {
        List<Integer> trueIdx = new ArrayList<>();
        List<Integer> falseIdx = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (visited[i]) trueIdx.add(i);
            else falseIdx.add(i);
        }

        int trueSum = listSum(trueIdx);
        int falseSum = listSum(falseIdx);

        return Math.abs(trueSum - falseSum);
    }
}
