package kb_algorithm.week6;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '.'; // 방문처리를 .으로
                    if (dfs(board, word, i, j, 0)) return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index + 1 == word.length()) return true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) continue; // 좌표 탐색

            if (board[nx][ny] == word.charAt(index + 1)) { // 다음 좌표가 다음 문자와 같으면
                board[nx][ny] = '.'; // 방문처리
                if (dfs(board, word, nx, ny, index + 1)) return true; // dfs 돌리기
                board[nx][ny] = word.charAt(index + 1); // 백트래킹
            }

        }
        return false;
    }
}