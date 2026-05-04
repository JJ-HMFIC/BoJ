import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Info>> map = new HashMap<>();
        
        for(int i= 0; i<plays.length;i++){
            if(map.keySet().contains(genres[i])) map.get(genres[i]).add(new Info(i,plays[i]));
            else{
                ArrayList<Info> list = new ArrayList<>();
                list.add(new Info(i,plays[i]));
                map.put(genres[i],list);
            }
        }
        
        Map<String,Integer> stat = new HashMap<>();
        for(String genre : map.keySet()){
            int sum = 0;
            Collections.sort(map.get(genre));
            for(Info cur : map.get(genre)) sum+= cur.play;
            stat.put(genre, sum);
        }
        List<String> genreOrder = new ArrayList<>(stat.keySet());
        
        genreOrder.sort((o1,o2)-> stat.get(o2) - stat.get(o1));
        
        List<Integer> answer = new ArrayList<>();
        for(String genre : genreOrder){
            List<Info> songs = map.get(genre);
            for(int i=0;i<Math.min(songs.size(),2);i++){
                answer.add(songs.get(i).num);
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
    public class Info implements Comparable<Info>{
        int num;
        int play;
        public Info(int num, int play){
            this.num = num;
            this.play = play;
        }
        public int compareTo(Info o){
            if(this.play == o.play) return this.num - o.num;
            return o.play - this.play;
        }
    }
}