import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int tmp : tangerine){
            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        
       list.sort(Collections.reverseOrder());
        
        
        int answer = 0;
        
        if(k==map.keySet().size()) return k;
        
        for(int i = 0 ; i<list.size();i++){
            // System.out.println(list.get(i));
            k -= list.get(i);
            answer++;
            if(k<=0) break;
        }
        return answer;
    }
}