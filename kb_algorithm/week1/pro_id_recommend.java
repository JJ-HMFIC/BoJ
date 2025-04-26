package kb_algorithm.week1;

public class pro_id_recommend {
    public String solution(String new_id) {
        //1단계 : 소문자로 바꾸기
        String step1 = new_id.toLowerCase();
        //2단계 : 숫자/문자/./_/- 만 살리기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < step1.length(); i++) {
            char ch = step1.charAt(i);
            if (Character.isLowerCase(ch)
                    || Character.isDigit(ch)
                    || ch == '-'
                    || ch == '_'
                    || ch == '.') {
                sb.append(ch);
            }
        }
        String step2 = sb.toString();
        sb.setLength(0);
        //3단계 : 연속으로 '.'이 나오면 맨 앞 '.'만 살리기
        for (int i = 0; i < step2.length(); i++) {
            char ch = step2.charAt(i);
            if (ch != '.' || sb.length() > 0 && sb.charAt(sb.length() - 1) != '.') {
                sb.append(ch);
            }
        }
        String step3 = sb.toString();
        sb.setLength(0);
        //4단계 : 맨 앞, 맨 뒤의 '.' 제거
        if (step3.startsWith(".")) {
            step3 = step3.substring(1);
        }
        if (step3.endsWith(".")) {
            step3 = step3.substring(0, step3.length() - 1);
        }
        String step4 = step3;
        //5단계 : 빈 문자열이면 a로 치환
        if (step4.isEmpty()) step4 = "a";
        String step5 = step4;
        //6단계 : 16길이 이상이면 15자까지만, 잘랐는데 마지막이 '.'이면 이것도 제거
        if (step5.length() > 15) {
            step5 = step5.substring(0, 15); // 정확히 앞 15자만 남김
            if (step5.endsWith(".")) {
                step5 = step5.substring(0, step5.length() - 1);
            }
        }
        StringBuilder step6 = new StringBuilder(step5);
        // 7단계 : 길이가 3 미만이면 마지막 글자를 채워 길이가 3이 되게 만들기
        while (step6.length() < 3) {
            step6.append(step6.substring(step6.length() - 1));
        }

        return step6.toString();
    }
}
