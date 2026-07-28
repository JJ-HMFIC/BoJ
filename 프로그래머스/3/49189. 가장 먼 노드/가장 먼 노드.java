import java.util.*;

class Solution {
    static int[] visited;
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] edge) {
        
        visited = new int[n+1];
        Arrays.fill(visited,-1);
        list = new ArrayList[n+1];
        
        for(int i=1 ; i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] info : edge){
            int a = info[0];
            int b = info[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        bfs(1);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i<=n;i++){
            max = Math.max(max, visited[i]);
        }
        int answer = 0;
        for(int i =0;i<=n;i++){
            if(visited[i]==max) answer++;
        }
        return answer;
    }
    public void bfs(int start){
        Deque<Info> deque = new ArrayDeque<>();
        deque.add(new Info(start,0));
        visited[start] = 0;
        
        while(!deque.isEmpty()){
            Info top = deque.poll();
            
            for(int next : list[top.node]){
                if(visited[next]==-1 || visited[next]>top.dist+1){
                    visited[next] = top.dist+1;
                    deque.add(new Info(next, top.dist+1));
                }
            }
        }
        
    }
    
    public class Info{
        int node;
        int dist;
        public Info(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}