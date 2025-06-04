package kb_algorithm.week5;

import java.util.*;

public class leet_group_anagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] tmp = word.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp); // 단어 알파벳순으로 정렬
            if (!map.containsKey(key)) { // 새로운 단어라면
                List<String> values = new ArrayList<>();
                values.add(word);
                map.put(key, values); // 새로 넣기
            } else {
                map.get(key).add(word); //아니면 기존 value(리스트)에 추가
            }
        }
    //return (List<List<String>>) map.values();
        return new ArrayList<>(map.values());
    }
}
