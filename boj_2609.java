import java.util.Scanner;

public class boj_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int g = gcd(N, M);
        int l = (N * M) / g; // 최소 공배수 = (a  * b )/ 최대공약수
        System.out.println(g);
        System.out.println(l);

    }
    public static int gcd(int a, int b){ // 유클리드 호재법
        while(b!=0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
