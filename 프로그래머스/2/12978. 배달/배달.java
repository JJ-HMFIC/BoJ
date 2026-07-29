import java.util.*;
class Solution {
    static ArrayList<Edge>[] list;
    static int[] distance;
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        list = new ArrayList[N+1];
        for(int i = 1 ; i<=N ;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] info : road){
            int a = info[0];
            int b= info[1];
            int w = info[2];
            
            list[a].add(new Edge(b,w));
            list[b].add(new Edge(a,w));
        }
        distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        
        visited= new boolean[N+1];
        dijkstra(1);
        int answer = 0;
        for(int w : distance){
            if(w<=K) answer++;
        }


        return answer;
    }
    public void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.add(new Edge(start,0));
        
        while(!pq.isEmpty()){
            Edge top = pq.poll();
            int v = top.v;
            int w = top.w;
            if(visited[v]) continue;
            visited[v] = true;
            for(Edge next : list[v]){
                int nv = next.v;
                int nw = next.w;
                
                if(distance[nv]>distance[v]+nw){
                    distance[nv] = distance[v]+nw;
                    pq.add(new Edge(nv,distance[v]+nw));
                }
            }
        }
    }
    public static class Edge implements Comparable <Edge>{
        int v;
        int w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.w, e.w);
        }
    }

}