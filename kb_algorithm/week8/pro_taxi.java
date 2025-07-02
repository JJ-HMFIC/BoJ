package kb_algorithm.week8;

class Solution {
    static int[][] map;
    static int count;
    static final int INF = 3000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        count = n;
        map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }

        }
        for (int[] info : fares) {

            int node1 = info[0];
            int node2 = info[1];
            int fare = info[2];

            map[node1][node2] = fare;
            map[node2][node1] = fare;
        }
        for (int k = 1; k < count + 1; k++) {
            for (int i = 1; i < count + 1; i++) {
                for (int j = 1; j < count + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int answer = INF;
        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, map[s][k] + map[k][a] + map[k][b]);
        }

        return answer;
    }
}