import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int[] in = new int[1000001];
        int[] out = new int[1000001];
        int maxNode = 0;
        
        for(int[] edge : edges){ // a->b
            int a = edge[0];
            int b = edge[1];
            
            out[a]++;
            in[b]++;
            maxNode = Math.max(maxNode, Math.max(a,b));
        }
        int start = 0;
        for(int i = 1; i<=maxNode;i++){
            if(in[i]==0 && out[i]>=2) start = i;
            else if(in[i]>=1 && out[i]==0) answer[2]++; 
            // 막대그래프 : 끝 정점은 나가는게 없음
            else if(in[i]>=2 && out[i]==2) answer[3]++;
            // 8자 그래프 : 중앙 노드는 in, out이 2개씩 있음
        }
        int total = out[start];
        // 전체 그래프는 출발 노드에서 나온 간선의 수
        answer[1] = total - answer[2] - answer[3];
        answer[0] = start;
        
        
        return answer;
    }
}