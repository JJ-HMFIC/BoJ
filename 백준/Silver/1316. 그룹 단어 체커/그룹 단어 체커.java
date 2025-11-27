import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {

            char currentChar = ' ';
            Set<Character> hashSet = new HashSet<>();
            String word = br.readLine();
            boolean check = true;

            for (int j = 0; j < word.length(); j++) {
                char lastChar = word.charAt(j);
                if(lastChar!=currentChar){
                    if (hashSet.contains(lastChar)) {
                        check = false;
                        break;
                    }
                    hashSet.add(lastChar);
                    currentChar = lastChar;
                }
            }
            if(check) answer++;
        }
        System.out.println(answer);
    }
}
