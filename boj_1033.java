import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class boj_1033 {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        A = new ArrayList[N]; // 인접리스트
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }
        visited = new boolean[N]; //탐색 배열
        D = new long[N]; // 각 노드값 저장 배열

        lcm = 1; // 최소 공배수
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b,p,q));
            A[b].add(new cNode(a,q,p));
            lcm *= ((p * q) / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1 ; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(D[i]/mgcd + " ");
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (cNode i : A[node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

    public static long gcd(long p, long q) {
        if (q == 0) {
            return p;
        }
        else
            return gcd(q, p % q);
    }
}
class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}

