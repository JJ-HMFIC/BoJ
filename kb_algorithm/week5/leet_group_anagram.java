package kb_algorithm.week5;

import java.util.*;

public class leet_group_anagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] tmp = word.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if (!map.containsKey(key)) {
                List<String> values = new ArrayList<>();
                values.add(word);
                map.put(key, values);
            } else {
                map.get(key).add(word);
            }
        }
    //return (List<List<String>>) map.values();
        return new ArrayList<>(map.values());
    }
}
