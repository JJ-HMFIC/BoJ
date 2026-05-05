import java.util.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0 ; i<arr.length;i++){
            if(i == 0 || arr[i-1] ==' '){
                if(!Character.isDigit(arr[i])){
                    arr[i] = Character.toUpperCase(arr[i]);
                }
            }else if(Character.isAlphabetic(arr[i])){
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr);
    }
}