package kb_algorithm.week8;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Position> pq;
    static ArrayList<Position>[] graph;

    class Position {
        int start;
        int end;
        int dist;

        public Position(int x, int y, int dist) {
            this.start = x;
            this.end = y;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] info : times) {
            int start = info[0];
            int end = info[1];
            int dist = info[2];
            graph[start].add(new Position(start, end, dist));
        }

        pq = new PriorityQueue<>();


    }
}