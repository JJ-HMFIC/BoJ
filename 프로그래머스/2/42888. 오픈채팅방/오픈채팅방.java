import java.util.*;
class Solution {
    public String[] solution(String[] record) {
       
        HashMap<String, String> map = new HashMap<>();
        for(String line : record){
            String[] log = line.split(" ");
            if(log[0].equals("Enter")|| log[0].equals("Change")){
                map.put(log[1],log[2]);
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i = 0 ;i<record.length;i++){
            String[] line = record[i].split(" ");
            if(line[0].equals("Enter")){
                answer.add(map.get(line[1])+"님이 들어왔습니다.");
            }
            if(line[0].equals("Leave")){
                answer.add(map.get(line[1])+"님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[0]);
    }
}