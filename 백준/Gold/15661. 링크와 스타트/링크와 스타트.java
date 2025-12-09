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
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전략 1: 0번 사람은 무조건 스타트팀(true)으로 고정
        // 탐색 범위를 절반으로 줄임
        visited[0] = true;
        // idx는 1부터 시작 (0번은 이미 정했으므로)
        // startSum, linkSum은 0부터 시작
        subset(1, 0, 0);
        System.out.println(min);
    }

    private static void subset(int idx, int startSum, int linkSum) {
        // 가지치기: 이미 현재 구한 최소값보다 차이가 크고, 남은 인원으로 역전 불가능해 보이면 끊을 수도 있음
        // 하지만 여기서는 min == 0 인 경우만 처리해도 충분히 빠름
        if(min==0) return;
        if (idx == N) {
            // 링크팀이 한 명도 없는 경우는 문제 조건상 제외해야 하지만,
            // 그 경우 차이가 매우 커지므로(전체 합 vs 0) min 갱신이 안 되어 자연스럽게 무시됨
            min = Math.min(min, Math.abs(startSum - linkSum));
            return;
        }
        // 검토할 새 멤버 idx
        int newStartSum = startSum;
        for (int i = 0; i < idx; i++) {// 0 ~ idx-1 까지만 확인 (현재까지 확정된 멤버들)
            if (visited[i]) {// 기존 멤버 i가 스타트팀이라면
                newStartSum += arr[i][idx] + arr[idx][i];// 서로의 시너지 추가
            }
        }
        visited[idx] = true;
        subset(idx + 1, newStartSum, linkSum);

        int newLinkSum = linkSum;
        for (int i = 0; i < idx; i++) {
            if (!visited[i]) {
                newLinkSum += arr[i][idx] + arr[idx][i];
            }
        }
        visited[idx] = false;
        subset(idx + 1, startSum, newLinkSum);
    }


}
