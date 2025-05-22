package kb_algorithm.week4;


public class pro_sheep_and_wolf {
    static boolean[] visited;

    public int solution(int[] info, int[][] edges) {
        //info : 각 인덱스에 양(0), 늑대(1)
        // edges: 간선 정보
        visited = new boolean[info.length];
        visited[0] = true; // 루트 방문하기

        return Dfs(info, edges, 1, 0);
        //0번 노드에는 항상 양이 있음
    }

    private int Dfs(int[] info, int[][] edges, int sheep, int wolf) {
        if (sheep == wolf) return sheep;
        //늑대가 양보다 크거나 같으면 빠져 나온다
        int maxSheep = sheep;

        for (int[] edge : edges) {
            //모든 간선 확인하기
            final int parent = edge[0];
            final int child = edge[1];
            //부모를 방문했는데 자식을 방문 안했으면
            if (visited[parent] && !visited[child]) {
                visited[child] = true; // 방문하기

                if (info[child] == 0) { // 자식이 양을 가지고 있으면
                    maxSheep = Math.max(maxSheep, Dfs(info, edges, sheep + 1, wolf));
                } else { // 늑대라면
                    maxSheep = Math.max(maxSheep, Dfs(info, edges, sheep, wolf + 1));
                }
                visited[child] = false; // 백트래킹
            }
        }
        return maxSheep;
        // 모을 수 있는 양의 최대 수 리턴
    }
}
