import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int pos = Collections.binarySearch(list, num);
                if (pos < 0) pos = -(pos + 1);
                list.set(pos, num);
            }
        }
        System.out.println(n - list.size());
    }
}
