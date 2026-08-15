import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> map = new HashMap<>(); // 신고 받은 횟수
        HashMap<String, Set<String>> go = new HashMap<>();
        for(String id : id_list){
            map.put(id,0);
            Set<String> list =new HashSet<String>();
            go.put(id, list);
        }
        int[] answer = new int[id_list.length];
        for(String ids : report){
            String who = ids.split(" ")[0];
            String whom = ids.split(" ")[1];
            
            if(!go.get(who).contains(whom)){
                go.get(who).add(whom);
                map.put(whom, map.get(whom)+1);
            }
        }
        for(int i =0;i<answer.length;i++){
            String id = id_list[i];
            for(String whom : go.get(id)){
                if(map.get(whom)>=k) answer[i]++;
            }
        }
        return answer;
    }
}