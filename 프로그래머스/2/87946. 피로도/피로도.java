class Solution {
    static boolean[] visited;
    static int n,answer;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
               
        answer = 0;
        
        dfs(k,0,dungeons);
        
        return answer;
    }
    public void dfs(int k, int cnt, int[][] dungeons){
        answer = Math.max(answer, cnt);
        
        
        for(int i = 0 ; i<n;i++){
            if(!visited[i] && k-dungeons[i][0]>=0){
                visited[i] = true;
                dfs(k-dungeons[i][1],cnt+1,dungeons);
                visited[i] = false;
            }
            
        }
        
        
        
    }
}