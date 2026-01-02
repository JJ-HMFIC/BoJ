
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] arr = line.split(" ");

            System.out.print("Case #" + i + ": ");
            StringBuilder sb = new StringBuilder();
            for (int j = arr.length - 1; j >= 0; j--) {
                String put = arr[j].trim();
                sb.append(put).append(" ");
            }
            System.out.println(sb);
        }
    }
}
