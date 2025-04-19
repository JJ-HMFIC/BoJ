package kb_algorithm.week1;

import java.util.HashMap;

public class pro_maraton {
    public String solution(String[] participant, String[] completion) {
        /*
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

         */
        // 얼리 리턴 방식
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String tmp : completion) {
            hashMap.compute(tmp, (key, value) -> (value == null) ? 1 : value + 1);
        } // completion의 요소를 순회하여 map 에 key,value로 저장

        for (String part : participant){
            // 참가자가 완주자 명단에 없다 or value 값이 0이다 => 정답
            if(!hashMap.containsKey(part) || hashMap.get(part)==0) return part;

            hashMap.compute(part, (key, value) -> value - 1);
            // 명단의 수 -1 계산
        }

        return null;
    }
}
