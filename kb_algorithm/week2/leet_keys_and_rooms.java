package kb_algorithm.week2;

import java.util.List;

public class leet_keys_and_rooms {
    public boolean[] visited; // 방문했는지 체크하는 배열

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()]; // 초기화
        DFS(0, rooms);

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) return false; // 하나라도 방문 안한 방이 있으면 false
        }
        return true;
    }

    private void DFS(int start, List<List<Integer>> rooms) {
        visited[start] = true; // 방문하고
        for (int next : rooms.get(start)) { // 해당 방의 열쇠를 순회(리스트)
            if (!visited[next]) { // 방에 있는 열쇠로 -> 다음 방을 가는데 방문 x면
                DFS(next, rooms); // dfs로 순회
            }
        }
    }
}
