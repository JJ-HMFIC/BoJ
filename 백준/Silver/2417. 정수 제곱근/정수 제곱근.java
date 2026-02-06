import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long answer = 0;
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (Math.pow(mid, 2) >= num) {
                answer = mid;
                right = mid -1;
            } else left = mid + 1;
        }
        System.out.println(answer);
    }
}
