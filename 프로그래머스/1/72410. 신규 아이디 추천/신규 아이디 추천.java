import java.util.*;
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); // step1
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<new_id.length();i++){
            char cur = new_id.charAt(i);
            if(Character.isLowerCase(cur)||Character.isDigit(cur)|| cur == '-'||cur=='_'||cur=='.') sb.append(cur);
        }//step2
        
        String step3 = sb.toString();
        while(step3.contains("..")){
            step3 = step3.replace("..",".");
        } //step3
        
        if(step3.startsWith(".")) step3 = step3.substring(1);
        if(step3.endsWith(".")) step3 = step3.substring(0,step3.length()-1); //step4
        
        if(step3.isEmpty()) step3+="a"; //step5
        
        if(step3.length()>=16) step3 = step3.substring(0,15);
        if(step3.endsWith(".")) step3 = step3.substring(0,step3.length()-1); //step6
        
        if(step3.length()<=2){
            String last = step3.substring(step3.length()-1);
            while(step3.length()<3){
                step3 +=last;
            }
        }
        
        
        return step3;
    }
}