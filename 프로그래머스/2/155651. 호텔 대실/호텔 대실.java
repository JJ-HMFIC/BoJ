import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        List<Guests> list = new ArrayList<>();
        for(String[] tmp : book_time){
            list.add(new Guests(calTime(tmp[0]), calTime(tmp[1])));
        }
        Collections.sort(list,(o1,o2)->{
            return o1.start - o2.start;
        });
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for(Guests guest: list){
            if(!rooms.isEmpty() && rooms.peek()<=guest.start){
                rooms.poll();
            }
            rooms.add(guest.end+10);
        }
        
        return rooms.size();
        
    }
    public int calTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        
        return h*60+m;
    }
    static class Guests{
        int start;
        int end;
        
        public Guests(int start, int end){
            this.start= start;
            this.end = end;
        }
    }
}