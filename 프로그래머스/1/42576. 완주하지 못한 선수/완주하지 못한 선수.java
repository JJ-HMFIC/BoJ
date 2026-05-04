import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String person : participant){
            if(map.keySet().contains(person)) map.put(person, map.get(person)+1);
            else map.put(person , 1);
        }
        for(String person : completion){
            if(map.get(person) == 1) map.remove(person);
            else map.put(person, map.get(person)-1);
        }
        
        return map.keySet().iterator().next();
    }
}