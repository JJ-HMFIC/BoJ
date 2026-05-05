class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            for(int i = 0; i<s.length();i++){
                if(s.charAt(i)=='0'){
                    answer[1]++;
                }
            }
            s = s.replace("0",""); //step1
            
            int len = s.length();
            s = Integer.toBinaryString(len);
            //step2
            answer[0]++;
        }
        
        return answer;
    }
}