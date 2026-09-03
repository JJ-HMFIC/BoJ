import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Grid> map = new HashMap<>();
        map.put(1,new Grid(0,0));
        map.put(2,new Grid(0,1));
        map.put(3,new Grid(0,2));
        map.put(4,new Grid(1,0));
        map.put(5,new Grid(1,1));
        map.put(6,new Grid(1,2));
        map.put(7,new Grid(2,0));
        map.put(8,new Grid(2,1));
        map.put(9,new Grid(2,2));
        map.put(0,new Grid(3,1));
        
        
        Grid left = new Grid(3,0);
        Grid right = new Grid(3,2);
        
        for(int number: numbers){
            if(number % 3 ==1) {
                sb.append("L");
                left = map.get(number);
            }
            else if(number % 3 == 0 && number > 0) {
                sb.append("R");
                right = map.get(number);
            }
            else {
                Grid cur = map.get(number);
                int ld = Math.abs(cur.x - left.x) + Math.abs(cur.y - left.y);
                int rd = Math.abs(cur.x - right.x) + Math.abs(cur.y - right.y);
                if(ld == rd) {
                    sb.append(hand.substring(0,1).toUpperCase());
                    if(hand.equals("left")) left = map.get(number);
                    else right = map.get(number);
                }
                else if(ld< rd){
                    sb.append("L");
                    left = map.get(number);
                }else {
                    sb.append("R");
                    right = map.get(number);
                }
            }
        }
        
        return sb.toString();
    }
    static class Grid{
        int x, y;
        public Grid(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}