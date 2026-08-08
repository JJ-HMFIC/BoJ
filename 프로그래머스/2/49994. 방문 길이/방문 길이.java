import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    // U D R L
    public int solution(String dirs) {
        int n = dirs.length();
        HashMap<Character, Integer> dir = new HashMap<>();
        dir.put('U',0);
        dir.put('D',1);
        dir.put('R',2);
        dir.put('L',3);
        int x = 0;
        int y = 0;
        Set<String> set= new HashSet<>();
        
        for(int i = 0 ; i<n;i++){
            char cur = dirs.charAt(i);
            
            int nx = x + dx[dir.get(cur)];
            int ny = y + dy[dir.get(cur)];
            if(nx<-5||ny<-5||nx>5||ny>5) continue;
            
            String tmp = x+","+y+" "+nx+","+ny;
            String tmp2 = nx+","+ny+" "+x+","+y;
            set.add(tmp);
            set.add(tmp2);
            
            x = nx;
            y = ny;
            
        }
        int answer = set.size();
        
        return answer/2;
    }
}