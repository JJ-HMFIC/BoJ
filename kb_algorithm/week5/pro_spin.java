package kb_algorithm.week5;

import java.util.*;

class pro_spin {
    public int solution(String s) {
        if(s.length() % 2 ==1) return 0; // 길이가 홀수면 의미 없음
        int count = 0;
        if(isSpin(s)) count++;
        // 처음도 대칭이면 카운트해야됌
        // 이거 안해서 틀림
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, 1);
            s = s.substring(1) + first;
            if(isSpin(s)) count++;
        }
        return count;
    }

    private boolean isSpin(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') stack.push(')');
            else if (s.charAt(i)=='{') stack.push('}');
            else if(s.charAt(i)=='[') stack.push(']');
            else if(!stack.isEmpty() &&s.charAt(i) == stack.peek()) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}