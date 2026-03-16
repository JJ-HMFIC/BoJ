import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] arr = line.split(" ");
        arr[N - 1] = arr[N - 1].trim();
        Set<String> set = new HashSet<>();
        for (String cheese : arr) {
            if(cheese.endsWith("Cheese")) set.add(cheese);
        }
        if(set.size()>=4) System.out.println("yummy");
        else System.out.println("sad");
    }
}
