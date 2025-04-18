package kb_algorithm.week1;

import java.util.*;

public class pro_budget {
    public int solution(int[] d, int budget) {
        int result = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (d[i] < budget) {
                budget -= d[i];
                result++;
            }
        }
        return result;
    }
}

