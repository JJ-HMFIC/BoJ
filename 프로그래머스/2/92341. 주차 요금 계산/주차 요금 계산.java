import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int btime = fees[0];
        int bfee = fees[1];
        int utime = fees[2];
        int ufee = fees[3];
        HashMap<String, String> map = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        
        for(String record : records){
            String[] log = record.split(" ");
            if(log[2].trim().equals("IN")){
                map.put(log[1],log[0]);
            }
            if(log[2].trim().equals("OUT")){
                String in = map.get(log[1]);
                int iH = Integer.parseInt(in.split(":")[0]);
                int iM = Integer.parseInt(in.split(":")[1]);
                int inTime = iH*60 + iM;
                // System.out.println(iM);
                String out = log[0];
                int oH = Integer.parseInt(out.split(":")[0]);
                int oM = Integer.parseInt(out.split(":")[1]);
                int outTime = oH*60+ oM;
                
                result.put(log[1],result.getOrDefault(log[1],0)+outTime-inTime);
                
                map.remove(log[1]);             
            }
        }
        for(String num : map.keySet()){
            int outTime = 23*60+59;
            String in = map.get(num);
            int iH = Integer.parseInt(in.split(":")[0]);
            int iM = Integer.parseInt(in.split(":")[1]);
            int inTime = iH*60 + iM;
            result.put(num,result.getOrDefault(num,0)+outTime-inTime);
        }
        
        int[] answer = new int[result.size()];
        int idx =0 ;
        for(int min : result.values()){
            if(min <=btime){
                answer[idx] = bfee;
            }else{
                int totalFee = (int)Math.ceil((double)(min-btime)/utime) * ufee + bfee;
                // double 형 변환 : int 형식으로 계산된다면 소수점 버리기 때문
                // ceil의 최종 타입 double -> int로 형변환해야 함
                answer[idx] = totalFee;
            }
            idx++;
        }
        return answer;
    }
}