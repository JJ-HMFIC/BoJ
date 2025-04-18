package kb_algorithm.week1;

import java.util.Arrays;

public class pro_prime_num {

    public int solution(int[] nums) {
        int result = 0;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp); // max값이 정해져 있음 => 문제에 나와있는 숫자를 보고 이걸로 new int [3001]
        int max = tmp[tmp.length - 1] + tmp[tmp.length - 2] + tmp[tmp.length - 3];
        boolean[] isPrime = new boolean[max + 1];


        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int a = nums[i];
                    int b = nums[j];
                    int c = nums[k];

                    int sum = a + b + c;
                    if (isPrime[sum]) result++;

                }
            }
        }
        return result;
    }

}

