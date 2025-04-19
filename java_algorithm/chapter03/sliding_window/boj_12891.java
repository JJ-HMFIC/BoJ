import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891 {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
        int result = 0;
        char[] A = new char[S]; // 입력 문자열
        checkArr = new int[4]; // ACGT 체크 배열 - 조건
        myArr = new int[4]; // ACGT 체크 배열 - 현재 상태
        checkSecret = 0; // 요건을 다 만족하는지 체크(A~T)

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++; // 만족해야할 문자가 0개일 경우 -> 조건 하나 만족해서 하나 올리기
        }
        // 부분 문자열 처음 받을 때 세팅
        for (int i = 0; i < P; i++) Add(A[i]);
        if (checkSecret == 4) result++;

        for (int i = P; i < S; i++) { // 슬라이딩 윈도우
            int j = i - P; // i : 부분 문자열의 맨끝, j : 부분 문자열의 맨 처음
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) result++;
        }
        System.out.println(result);
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if(myArr[0]==checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1]==checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2]==checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3]==checkArr[3]) checkSecret--;
                myArr[3]--;
                break;

        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A' :
                myArr[0]++;
                if(myArr[0]==checkArr[0]) checkSecret++; // 동일할때만 체크++
                // why? 한번만 올리면 되기 때문에, 이상일 경우 계속 올라감
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1]==checkArr[1]) checkSecret++;
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2]==checkArr[2]) checkSecret++;
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3]==checkArr[3]) checkSecret++;
                break;

        }
    }
}
