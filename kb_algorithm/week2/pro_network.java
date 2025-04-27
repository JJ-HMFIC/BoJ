package kb_algorithm.week2;

public class pro_network {
    public boolean[] visited; // 방문했는지 체크하는 배열

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0; // 네트워크 개수
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문 안했으면
                answer++; // 일단 네트워크는 하나 찾은 것이다
                DFS(i, computers, n); // DFS를 돌려서 어디까지 연결 되어 있는지 찾자
            }
        }
        return answer;
    }

    private void DFS(int i, int[][] computers, int n) {
        visited[i] = true; // 해당 인덱스는 방문했다
        for (int j = 0; j < n; j++) { // 연결되어 있는 노드를 찾기
            if ( computers[i][j] == 1 && !visited[j]) {
                // i != j를 안해도 되는 이유
                // visited 가 이미 true가 되어있음
                // 연결되어 있으면 dfs를 타고 들어가기
                DFS(j, computers, n);
            }
        }
    }
}
