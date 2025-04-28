package study_algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_21939 {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Problem> minPQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.L == o2.L) return o1.P - o2.P; // 난이도 같으면 번호 작은 순
            return o1.L - o2.L; // 난이도 낮은 순
        }); // recommend : -1

        PriorityQueue<Problem> maxPQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.L == o2.L) return o2.P - o1.P; // 난이도 같으면 번호 큰 순
            return o2.L - o1.L; // 난이도 높은 순
        }); // recommend : 1

        Map<Integer, Integer> solved = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) { // 문제 저장
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            solved.put(p, l); // 일단 못풀었으니 들어가
            minPQ.add(new Problem(p, l));
            maxPQ.add(new Problem(p, l));
        }
//-------------------------------------------------------
        /*
         * 문제 추천하기
         */
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                minPQ.add(new Problem(p, l));
                maxPQ.add(new Problem(p, l));
                solved.put(p, l);
            } else if (command.equals("recommend")) {
                int type = Integer.parseInt(st.nextToken());
                PriorityQueue<Problem> tmp = (type == 1) ? maxPQ : minPQ;

                while (true) {
                    if (solved.containsKey(tmp.peek().getP()) // 문제 번호가 추천 목록에 있고
                            && solved.get(tmp.peek().getP())==tmp.peek().getL()) { // 그 레벨이 맞으면
                        sb.append(tmp.peek().getP()).append("\n"); // 그 문제를 추천함
                        break;
                    }
                    tmp.poll(); // solved 목록에 없다 => 풀었다 => 우선순위 큐에서 제거하기
                    // Lazy Deletion 방식 ~ 시간 복잡도 때문
                    //PriorityQueue에서 직접 remove하면 무조건 터진다.

                }


            } else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                solved.remove(p); // 풀면 map에서 빼버림 => map에 없으면 풀어버린 것

//                ✅ solved 명령 처리
//                실제 PriorityQueue에서 지우진 않고,
//                Map에만 기록
//                recommend할 때 만났을 때만 poll()해서 지운다.
//                (→ Lazy Deletion 방식!)
                // solved 명령어가 올 때는 Map에서 키만 삭제 → O(1) (HashMap 기본 연산)

            }
        }

        System.out.print(sb);
    }
}

class Problem {
    int P; // 문제 번호
    int L; // 난이도


    public Problem(int p, int l) {
        this.P = p;
        this.L = l;
    }


    public int getP() {
        return P;
    }

    public int getL() {
        return L;
    }
}
