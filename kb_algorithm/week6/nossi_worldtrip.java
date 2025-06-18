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
            if (balance >= countries[i][1]) {
                if (!visited[i]) {
                    visited[i] = true;
                    max = Math.max(max, permute(balance - countries[i][0], countries) + 1);
                    visited[i] = false;
                }
            }
        }

        return max;
    }
}