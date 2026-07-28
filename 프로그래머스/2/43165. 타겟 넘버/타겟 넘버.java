import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        bfs(numbers,target);
        
        return answer;
    }
    public void bfs(int[] numbers, int target){
        Deque<Info> deque = new ArrayDeque<>();
        deque.add(new Info(1,numbers[0]));
        deque.add(new Info(1,-numbers[0]));
        
        while(!deque.isEmpty()){
            Info top = deque.poll();
            
            if(top.cnt == numbers.length){
                if(top.sum == target) answer++;
            }
            else{
                deque.add(new Info(top.cnt+1,top.sum+numbers[top.cnt]));
                deque.add(new Info(top.cnt+1,top.sum-numbers[top.cnt]));
            }
        }
    }
    public class Info{
        int cnt;
        int sum;
        public Info(int cnt, int sum){
            this.cnt = cnt;
            this.sum = sum;
        }
    }
}