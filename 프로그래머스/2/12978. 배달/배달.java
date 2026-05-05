import java.util.*;

class Solution {
    static ArrayList<Info>[] list;
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        list = new ArrayList[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 1 ; i<=N ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i< road.length;i++){
            list[road[i][0]].add(new Info(road[i][1],road[i][2]));
            list[road[i][1]].add(new Info(road[i][0],road[i][2]));
        }
        dijkstra(N,K);
        int answer = 0;
        for(int i =1 ; i<=N;i++){
            if(distance[i]<=K) answer++;
        }
    

        return answer;
    }
    public void dijkstra(int N, int K){
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        distance[1] = 0;
        pq.add(new Info(1,0));
        
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            int vertex = cur.vertex;
            if(visited[vertex]) continue;
            visited[vertex] = true;
            
            for(int i = 0 ;i< list[vertex].size();i++){
                Info next = list[vertex].get(i);
                int nVertex = next.vertex;
                int nEdge = next.edge;
                
                if(distance[nVertex]> distance[vertex]+ nEdge){
                    distance[nVertex] = distance[vertex]+ nEdge;
                    pq.add(new Info(nVertex, distance[vertex]+nEdge));
                }
            }
            
        }
        
    }
    public class Info implements Comparable<Info>{
        int vertex;
        int edge;
        public Info(int vertex, int edge){
            this.vertex = vertex;
            this.edge = edge;
        }
        public int compareTo(Info o){
            return Integer.compare(this.edge, o.edge);
        }
    }
}