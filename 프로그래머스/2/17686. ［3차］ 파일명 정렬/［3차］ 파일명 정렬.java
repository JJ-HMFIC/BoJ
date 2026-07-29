import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        ArrayList<fileName> list = new ArrayList<>();
        for(int i = 0 ;i<files.length;i++){
            String file = files[i];
            
            int idx = 0;
            while(idx<file.length() && !Character.isDigit(file.charAt(idx))) idx++;
            String head = file.substring(0,idx);
            
            int idx2 = idx;
            while(idx2<file.length() && Character.isDigit(file.charAt(idx2)) && (idx2-idx)<5) idx2++;
            String num = file.substring(idx,idx2);
            
            list.add(new fileName(head,num,i,file));
            
        }
        Collections.sort(list);
        // return list.toArray(new String[0]);
        String[] answer = new String[list.size()];
        for(int i = 0 ; i<answer.length;i++){
            answer[i] = list.get(i).file;
        }
        return answer;
    }
    public static class fileName implements Comparable<fileName>{
        String head;
        String num;
        int idx;
        String file;
        public fileName(String head, String num, int idx,String file){
            this.head = head;
            this.num = num;
            this.idx = idx;
            this.file = file;
        }
        public int compareTo(fileName o){
            int headCompare = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if(headCompare!= 0) return headCompare;
            
            int num1 = Integer.parseInt(this.num);
            int num2 = Integer.parseInt(o.num);
            if(num1 != num2) return Integer.compare(num1,num2);
            
            return Integer.compare(this.idx, o.idx);
        }
    }
}

