package kb_algorithm.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static ArrayList<Info>[] graph;
    class Info {
        int node;
        double prob;

        public Info(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start_node, int end_node) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            double chance = succProb[i];

            graph[start].add(new Info(end, chance));
            graph[end].add(new Info(start, chance));
        }

        double[] possible = new double[n];
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
//        Arrays.fill(possible, 0);
        pq.offer(new Info(start_node, 1)); // 확률이니까 가장 큰 값은 1이다
        possible[start_node] = 1;

        while (!pq.isEmpty()) {
            Info top = pq.poll();

            for (Info next : graph[top.node]) {
                double nextProb = next.prob * possible[top.node];
                if (nextProb > possible[next.node]) {
                    possible[next.node] = nextProb;
                    pq.add(new Info(next.node, nextProb));
                }
            }
        }

        return possible[end_node];
    }
}