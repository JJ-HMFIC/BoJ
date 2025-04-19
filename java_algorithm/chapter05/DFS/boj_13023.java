import java.util.ArrayList;
import java.util.Scanner;

public class boj_13023 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) {
        arrive = false;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) A[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println("1"); //arrive가 true라면 깊이 = 5인 경로가 있음을 의미함
        else System.out.println("0");
    }

    public static void DFS(int now, int depth) {
        if (depth == 5 || arrive) { // 깊이가 5거나 이미 깊이가 5인 경로를 찾았다면(arrive)
            arrive = true; // 상태를 유지하고
            return; // 리턴한다
        }
        visited[now] = true; //방문 했음
        for (int i : A[now]) { // 현재 번호의 친구
            if (!visited[i]) { // 방문안했으면 DFS 실행
                DFS(i,depth+1);
            }
        }
        visited[now] = false; // 길을 잘못 들었을 경우 처음부터 다시하기 위해 false로 초기화
    }
}
