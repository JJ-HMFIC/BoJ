package kb_algorithm.week6;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        //grid = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(board,word,i,j)) return true;
                }
            }

        }
        return false;
    }

    private boolean dfs(char[][] board, String word,int x, int y) {


        return false;
    }
}