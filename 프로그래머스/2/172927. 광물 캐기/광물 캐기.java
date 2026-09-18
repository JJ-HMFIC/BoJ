import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        // picks : 다이아, 철, 돌 순서
        int[][] board = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        
        PriorityQueue<Mineral> pq = new PriorityQueue<>();
        int dia = 0;
        int iron = 0;
        int stone = 0;
        int idx = 0;
        int mineral = (picks[0]+picks[1]+picks[2]) * 5;
        int len = Math.min(minerals.length, mineral);
        while(idx<len){           
            String cur = minerals[idx];
            if(cur.equals("diamond")) dia ++;
            else if(cur.equals("iron")) iron ++;
            else stone ++;
            idx++;
            
            if(idx %5 ==0){
                pq.add(new Mineral(dia,iron,stone));
                dia = 0;
                iron = 0;
                stone = 0;
            }
        }
        if(dia!=0 || iron!=0||stone != 0){
            pq.add(new Mineral(dia,iron,stone));
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            Mineral cur = pq.poll();
            if(picks[0]>0){
                answer+= board[0][0] * cur.dia
                        + board[0][1] * cur.iron
                        + board[0][2] * cur.stone;
                picks[0]--;
                continue;
            }
            if(picks[1]>0){
                answer+= board[1][0] * cur.dia
                        + board[1][1] * cur.iron
                        + board[1][2] * cur.stone;
                picks[1]--;
                continue;
            }
            if(picks[2]>0){
                answer+= board[2][0] * cur.dia
                        + board[2][1] * cur.iron
                        + board[2][2] * cur.stone;
                picks[2]--;
                continue;
            }
            
        }
        return answer;
    }
    public class Mineral implements Comparable<Mineral>{
        int dia,iron,stone;
        public Mineral(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        public int compareTo(Mineral m){
            if(this.dia == m.dia){
                if(this.iron == m.iron){
                    return Integer.compare(m.stone, this.stone);
                }
                return Integer.compare(m.iron, this.iron);
            }
            return Integer.compare(m.dia, this.dia);
        }
    }
}