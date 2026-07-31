import java.util.*;
import java.util.regex.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(String term : terms){
            char a = term.charAt(0);
            int b = Integer.parseInt(term.split(" ")[1]);
            map.put(a,b);
        }
        int day = calDay(today);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<privacies.length;i++){
            String p = privacies[i];
            char term = p.charAt(p.length()-1);
                        
            int cal = map.get(term);
            
            int pday = calDay(p.split(" ")[0]) + cal*28;
            
            if(pday<=day) list.add(i+1);
            
        }
        int[] answer = new int[list.size()];
        for(int i =0 ;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int calDay(String today){
        int year = Integer.parseInt(today.split(Pattern.quote("."))[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        return year*28*12 + month *28 + day;
    }
}