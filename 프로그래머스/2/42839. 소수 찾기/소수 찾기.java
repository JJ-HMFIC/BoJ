import java.util.*;
class Solution {
    static int answer, n;
    static boolean[] visited;
    static char[] arr;
    static Set<Integer> set;
    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        
        arr= numbers.toCharArray();
        answer = 0;
        n = numbers.length();
        dfs(0, 0);
        
        return answer;
    }
    public void dfs(int num, int cnt){
        if(isPrime(num) && !set.contains(num)){ 
            answer++;
            set.add(num);
        }
        if(cnt == n){
            return;
        }
        for(int i = 0 ; i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(num*10+(arr[i]-'0'), cnt+1);
                visited[i]= false;
            }
        }
    }
    public boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2 ; i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
        
    }
}