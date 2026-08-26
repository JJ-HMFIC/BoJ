import java.util.*;
class Solution {
    static ArrayList<Grid>[] list ;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        list = new ArrayList[n+1];
        
        
        for(int i = 1; i<=n ;i++){
            list[i] = new ArrayList<>();
        }
        for(int [] fare : fares){
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];
            list[x].add(new Grid(y,cost));
            list[y].add(new Grid(x,cost));
        }
        
        int[] dists = dijkstra(s, n);
        int[] dista = dijkstra(a, n);
        int[] distb = dijkstra(b, n);
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1 ; i<=n ;i++){
            int cost = dists[i] + dista[i] + distb[i];
            answer = Math.min(cost,answer);
        }
        return answer;
      
    }
    public int[] dijkstra(int start, int n){
        PriorityQueue<Grid> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Grid(start, 0));
        
        while(!pq.isEmpty()){
            Grid top = pq.poll();
            int v = top.v;
            int w = top.w;
            if(visited[v]) continue;
            visited[v] = true;
            
            for(Grid next : list[v]){
                int nv = next.v;
                int nw = next.w;
                if(distance[nv]>distance[v]+nw){
                    distance[nv] = distance[v]+nw;
                    pq.add(new Grid(nv, distance[nv]));
                }
            }
            
        }
        return distance;
    }
    public class Grid implements Comparable<Grid>{
        int v;
        int w;
        public Grid(int v,int w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(Grid o){
            return Integer.compare(this.w, o.w);
        }
    } 
}