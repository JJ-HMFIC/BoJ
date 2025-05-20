package kb_algorithm.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class nossi_folder {
    public String solution(String[][] folders, String p, String q) {
        Map<String, String> map = new HashMap<>();
        for (String[] folder : folders) {
            map.put(folder[1], folder[0]); //자식, 부모 한 쌍
        }

       ;
        return LCA(map, p, q);
    }

    private String LCA(Map<String, String> map, String p, String q) {
        Set<String> visited = new HashSet<>();

        while (p != null) {
            visited.add(p);
            p = map.get(p); // 부모로 올라가기
        }
        while (q != null) {
            if (visited.contains(q)) return q; // 중간에 부무였다면 q를 리턴
            q = map.get(q);
        }

        return "root";
    }
}
