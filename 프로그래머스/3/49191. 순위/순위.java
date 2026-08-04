import java.util.*;
class Solution {
    public ArrayList<Integer>[] win;
    public ArrayList<Integer>[] lose;
    public int len;
    public int solution(int n, int[][] results) {
        win= new ArrayList[n+1];
        lose= new ArrayList[n+1];
        len = n;
        for(int i = 1; i<=n ; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            win[a].add(b);
            lose[b].add(a);
        }
        int answer = 0;
        for(int i =1 ; i<=n ;i++){
            if(bfs_win(i) + bfs_lose(i) == n-1) answer++;
        }
        return answer;
    }
    public int bfs_win(int start){
        boolean[] visited = new boolean[len+1];
        Deque<Integer> q = new ArrayDeque<>();
        int result = 0;
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int top = q.poll();
            
            for(int next : win[top]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    result++;
                }
            }
        }
        return result;
    }
    public int bfs_lose(int start){
        boolean[] visited = new boolean[len+1];
        Deque<Integer> q = new ArrayDeque<>();
        int result = 0;
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int top = q.poll();
            
            for(int next : lose[top]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    result++;
                }
            }
        }
        return result;
    }
}