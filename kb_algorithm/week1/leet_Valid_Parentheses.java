package kb_algorithm.week1;

import java.util.Stack;

public class leet_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>(); //array 기반 deque 좀 더 빨라 LL이라서 << 이걸로 리팩토링

        if(s.length()%2==1) return false;
        String open = "({["; // 비효율적
//        String close = ")}]";
        for (int i = 0; i < s.length(); i++) {
            String tmp = String.valueOf(s.charAt(i));
            if (open.contains(tmp)) { //set , 열린 괄호일때 닫힌 괄호를 같이 푸쉬 하고 (())
                stack.push(tmp);
            }
            else{
                if (stack.isEmpty()) return false; // 열린 괄호일 때 닫힘 괄호 같이 푸쉬해버리기
                if (tmp.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else if (tmp.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                }else if (tmp.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}
