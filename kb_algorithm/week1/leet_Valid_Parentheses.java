package kb_algorithm.week1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leet_Valid_Parentheses {
    public boolean isValid(String s) {
        //array 기반 deque 좀 더 빨라 LL이라서 << 이걸로 리팩토링
//        Stack<String> stack = new Stack<>();
        Deque<Character> stack = new ArrayDeque<>();

        if (s.length() % 2 == 1) return false;
//        String open = "({["; // 비효율적
//        String close = ")}]";

//        for (int i = 0; i < s.length(); i++) {
//            String tmp = String.valueOf(s.charAt(i));
//            if (open.contains(tmp)) { //set , 열린 괄호일때 닫힌 괄호를 같이 푸쉬 하고 (())
//                stack.push(tmp);
//            } else {
//                if (stack.isEmpty()) return false; // 열린 괄호일 때 닫힘 괄호 같이 푸쉬해버리기
//                if (tmp.equals(")") && stack.peek().equals("(")) {
//                    stack.pop();
//                } else if (tmp.equals("}") && stack.peek().equals("{")) {
//                    stack.pop();
//                } else if (tmp.equals("]") && stack.peek().equals("[")) {
//                    stack.pop();
//                } else return false;
//            }
//        }
        for (char p : s.toCharArray()){
            // 열린 괄호면 -> 짝에 맞게 닫힌 괄호를 푸쉬
            // only 닫힌 괄호만 푸쉬하여 후에 비교
            if (p == '(') {
                stack.push(')');
            } else if (p=='{') {
                stack.push('}');
            }else if(p=='['){
                stack.push(']');
                // 문자열 순회 중) 현재 문자가 닫힌 괄호고, 일치하면 팝
            } else if (!stack.isEmpty() && stack.peek()==p) {
                stack.pop();
                // 위에 해당사항이 없다 => 짝이 안맞음
            } else return false;
        } // 비어있으면 true 아니면 false
        return stack.isEmpty();
    }
}
