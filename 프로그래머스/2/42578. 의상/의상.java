import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String[] gear : clothes){
            if(map.keySet().contains(gear[1])) map.get(gear[1]).add(gear[0]);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(gear[0]);
                map.put(gear[1],list);
            }
        }
        int answer =1;
       
        for(String gear : map.keySet()){
            answer *= map.get(gear).size()+1;
        }
        return answer-1;
    }
}