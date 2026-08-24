import java.util.*;
class Solution {
    static HashMap<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        
        for(String line : info){
            String[] cur = line.split(" ");
           
            String lang = cur[0];
            String field = cur[1];
            String career = cur[2];
            String food = cur[3];
            String[] tmp = {lang, field, career, food};
            
            int score = Integer.parseInt(cur[4]);
            makeKeys(tmp,score,0,"");
        }
        
        for(List<Integer> scores: map.values()){
            Collections.sort(scores);
        }
        
        int[] answer = new int[query.length];
        
        for(int i = 0 ; i<query.length;i++){
            String line = query[i];
            String[] cur = line.split(" and ");
           
            String lang = cur[0];
            String field = cur[1];
            String career = cur[2];
            String food = cur[3].split(" ")[0];
            String tmp = lang+field+career+food;
            int score = Integer.parseInt(cur[3].split(" ")[1]);
            List<Integer> scores = map.getOrDefault(tmp,Collections.emptyList());
            if(scores.isEmpty()){
                answer[i] = 0;
            }else answer[i] = lowerBound(scores,score);
            
            
            
        }
        return answer;
    }
    static public void makeKeys(String[] tmp, int score, int idx, String key){
        if(idx == 4){
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(score);
            return;
        }
        makeKeys(tmp,score,idx+1,key+tmp[idx]);
        makeKeys(tmp,score,idx+1,key+"-");
        
    }
    public int lowerBound(List<Integer> list , int score){
        int l = 0;
        int r = list.size();
        
        while(l<r){
            int mid = (l+r)/2;
            
            if(list.get(mid)>=score) r = mid;
            else l = mid+1 ;
        }
        
        return list.size() - l;
    }
}