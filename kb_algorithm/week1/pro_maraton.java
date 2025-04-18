package kb_algorithm.week1;

import java.util.HashMap;

public class pro_maraton {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (!hashMap.containsKey(participant[i])) {
                hashMap.put(participant[i], 1);//없으면 1
            } else {
                hashMap.put(participant[i], hashMap.get(participant[i]) + 1); // 있으면 기존 +1
            }
        }
        for (int i = 0; i < completion.length; i++) {
            hashMap.put(completion[i], hashMap.get(completion[i]) - 1);
        } // 완주자 제거
        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) > 0) {
                return name;
            }
        }

        return "";
    }
}
