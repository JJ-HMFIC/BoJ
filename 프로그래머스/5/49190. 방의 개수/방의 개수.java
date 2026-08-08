import java.util.*;
class Solution {
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public int solution(int[] arrows) {
        
        int answer = 0;
        int x = 0;
        int y = 0;
        Set<String> visitV = new HashSet<>();
        Set<String> visitE = new HashSet<>();
        
        visitV.add(x+","+y);
        for(int i=0; i<arrows.length;i++){
            int dir = arrows[i];
            for(int j = 1; j<=2 ;j++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                String next = nx+","+ny;
                String nextE = x+","+y+"->"+next;
                String nextE2 = next+"->"+x+","+y;
                
                if(visitV.contains(next) && !visitE.contains(nextE)) answer++;
                visitV.add(next);
                visitE.add(nextE);
                visitE.add(nextE2);
                
                x =nx;
                y = ny;
                
            }
        }
        return answer;
    } 
}