import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char at = line.charAt(i);
            sb.append(at);

            int len = sb.length();
            if (len >= 4) {
                if (sb.charAt(len - 1) == 'P'
                        && sb.charAt(len - 2) == 'A'
                        && sb.charAt(len - 3) == 'P'
                        && sb.charAt(len - 4) == 'P'
                ) {
                    sb.delete(len - 4, len - 1);
                }
            }
        }

        if (sb.toString().equals("P")) {
            System.out.println("PPAP");
        } else System.out.println("NP");

    }
}
