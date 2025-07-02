package kb_algorithm.week8;

import java.util.ArrayList;

class Solution {
    static ArrayList<Entry>[] graph;
    class Entry{
        int node;
        int dist;

        public Entry(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // paths : 그래프 정보
        // gates : 시작점 정보
        // summits : 산봉우리 정보
        int[] answer = {};
        return answer;
    }
}