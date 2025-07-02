package kb_algorithm.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Position> pq;
    static ArrayList<Position>[] graph;
    class Position implements Comparable<Position> {
        int node;
        int dist;

        public Position(int y, int dist) {

            this.node = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Position other) {
            return this.dist - other.dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] info : times) {
            int start = info[0];
            int end = info[1];
            int dist = info[2];
            graph[start].add(new Position(end, dist));
        }

        int INF = Integer.MAX_VALUE;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);

        pq = new PriorityQueue<>();
        pq.add(new Position(k, 0));
        distance[k] = 0;

        while (!pq.isEmpty()) {

            Position top = pq.poll();
            if (top.dist > distance[top.node]) continue;

            int dist = top.dist;
            int node = top.node;

            for (Position next : graph[node]) {
                int nextDist = dist + next.dist;
                if (nextDist < distance[next.node]) {
                    distance[next.node] = nextDist;
                    pq.add(new Position(next.node, nextDist));
                }
            }

        }
        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            if(distance[i]== INF) return -1;
            answer = Math.max(answer, distance[i]);
        }

        return answer;

    }


}