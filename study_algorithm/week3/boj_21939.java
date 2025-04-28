package study_algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_21939 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Problem> pq = new PriorityQueue<>((o1, o2) -> {
            int L1 = o1.getL();
            int L2 = o2.getL();
            if (L1 == L2) return o1.getP() - o2.getP(); // 문제 번호가 큰 게 뒤로가
            else return L1 - L2; // 난이도가 어려운게 뒤로가
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            pq.add(new Problem(p, l));
        }
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = st.nextToken();

            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                pq.add(new Problem(p, l));

            } else if (command.equals("recommend")) {
                int remover = Integer.parseInt(st.nextToken());

                if (remover == -1) {
                    System.out.println(pq.poll().getP()); // 일단 여기까지
                }
            }
        }
    }
}

class Problem {
    int P; // 문제 번호
    int L; // 난이도

    public Problem(int p, int l) {
        P = p;
        L = l;
    }

    public int getP() {
        return P;
    }

    public int getL() {
        return L;
    }
}