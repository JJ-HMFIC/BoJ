package kb_algorithm.week5;

import java.util.*;

class pro_spin {
    public int solution(String s) {
        if(s.length() % 2 ==1) return 0; // 길이가 홀수면 의미 없음
        int count = 0;
        //if(isSpin(s)) count++;

        for (int i = 0; i < s.length(); i++) {
            // 0~ length-1까지 반복하기 때문에
            // 원본까지 돌아온다
            // 그래서 처음 상태를 조사 안해도 된다 -> 인덱스 차이임
            String first = s.substring(0, 1);
            // 맨 앞글자 잘라서
            s = s.substring(1) + first;
            // 맨뒤에 붙이고
            if(isSpin(s)) count++; // 대칭인지 조사
        }
        return count;
    }

    private boolean isSpin(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            // 여는 괄호면 닫는괄호를 스택에 푸쉬
            if(s.charAt(i)=='(') stack.push(')');
            else if (s.charAt(i)=='{') stack.push('}');
            else if(s.charAt(i)=='[') stack.push(']');
            else if(!stack.isEmpty() &&s.charAt(i) == stack.peek()) stack.pop();
            //닫는 괄호면 스택에서 꺼내기
            else return false;
            // 짝이 안맞으면 대칭이 아니다
        }
        return stack.isEmpty();
    }
}