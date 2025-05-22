package kb_algorithm.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class nossi_folder {
    public String solution(String[][] folders, String p, String q) {
        Map<String, String> map = new HashMap<>();
        for (String[] folder : folders) {
            map.put(folder[1], folder[0]); //[자식, 부모] 한 쌍으로 저장
        }

       ;
        return LCA(map, p, q);
    }

    private String LCA(Map<String, String> map, String p, String q) {
        Set<String> visited = new HashSet<>();

        while (p != null) {
            visited.add(p); // 경로를 set에 저장함
            p = map.get(p); // 부모로 올라가기
        }
        while (q != null) {
            if (visited.contains(q)) return q;
            // 타고 올라가는데 경로에 있으면 LCA
            q = map.get(q); // 부모로 올라가기
        }

        return "root"; // 안만났으면 루트
    }
}
