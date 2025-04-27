package kb_algorithm.week2;

import java.util.Arrays;
import java.util.*;

public class pro_word_change {
    public int solution(String begin, String target, String[] words) {
        List<String> tmp = Arrays.asList(words); // 메서드 공부하기

        if (!tmp.contains(target)) return 0; // 타겟이 없으면 얼리 리턴

        int result = BFS(begin, target, words);

        return result;
    }

    private int BFS(String begin, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        // ★ 기존 문제와 다르게 visited를 set으로 설정
        // => 문자열 비교이기 때문에 인덱스로 하기 힘들어서
        Queue<Word> queue = new LinkedList<>();
        // 클래스 사용 : 들어가야 할 값 , 단어(String), 깊이(int)
        // 타입이 다름 = 클래스 사용하기 => 그냥 여러 값이 들어가야하면 클래스를 애용하자
        queue.offer(new Word(begin, 0)); // 초기값 넣기
        visited.add(begin); // 방문함
        while (!queue.isEmpty()) {
            Word now = queue.poll(); // 현재 노드
            String cur_word = now.getWord(); // 현재 노드 단어
            int cur_depth = now.getDepth(); // 현재 노드의 깊이

            if (cur_word.equals(target)) return cur_depth; // 같으면 현재 깊이 리턴
            for (String word : words) { // 문자열 배열 돌면서
                if (!visited.contains(word) && isConvertible(cur_word, word)) {
                    //방문 안했고, 현재 노드와 다른 글자가 1개면
                    visited.add(word); // 방문하고
                    queue.offer(new Word(word, cur_depth + 1)); // 큐에 넣기
                }
            }
        }
        return visited.size();
    }

    private boolean isConvertible(String begin, String target) {
        // 문자열 순회하면서 몇 개의 글자가 다른지 조사하는 함수
        // 이게 가능한 이유 = 단어 길이가 같으니까
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return (diff == 1);
    }
}
// 클래스 사용
class Word {
    String word;
    int depth;

    public Word(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }

    public String getWord() {
        return word;
    }

    public int getDepth() {
        return depth;
    }
}
