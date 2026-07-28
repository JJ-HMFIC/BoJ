import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;
    public int solution(int n, int[][] computers) {
        
        list = new ArrayList[n+1];
        
        for(int i = 1 ; i<=n ; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i<n; i++){
            for(int j = 0;j<n ; j++){
                if(i!=j && computers[i][j]==1){
                    list[i+1].add(j+1);
                }
            }
        }
        visited = new boolean[n+1];
        answer = 0;
        for(int i =1 ; i<=n; i++){
            if(!visited[i]) bfs(i);
        }
        
        
        return answer;
    }
    public void bfs(int start){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            
            for(int next : list[top]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        answer++;
    }
}