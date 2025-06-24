package kb_algorithm.week6;

class Solution {
    static int answer = -1;
    static boolean[] visited;
    public int solution(int balance, int[][] countries) {
        int n = countries.length;
        visited = new boolean[n];

        answer = permute(balance, countries);
        return answer;
    }

    private int permute(int balance, int[][] countries) {
        if(balance < 0) return -1;
        int max = 0;
        for (int i = 0; i < countries.length; i++) {
            if (balance >= countries[i][1]) { // 입국 필요 잔고보다 크거나 같은데
                if (!visited[i]) { // 해당 국가를 방문 안했으면
                    visited[i] = true; //방문하고
                    max = Math.max(max, permute(balance - countries[i][0], countries) + 1);
                    // 방문한 걸 가정하고 재귀 돌리기
                    visited[i] = false; // 백트래킹
                }
            }
        }

        return max;
    }
}