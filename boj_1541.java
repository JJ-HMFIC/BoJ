import java.util.Scanner;

public class boj_1541 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int tmp = mySum(str[i]);
            if (i == 0) {
                answer += tmp; // 가장 앞부분의 값만 더함
            } else {
                answer -= tmp;
            }
        }
        System.out.println(answer);
    }

    static int mySum(String s) {
        int sum = 0;
        String[] temp = s.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
