package kb_algorithm.week1;

import java.util.Arrays;

public class leet_two_sum {
    //    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) return new int[]{i, j};
//            }
//        }
//        return null;
//    }
//    public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int l = 0, r = nums.length-1;
//        while (l < r) {
//            if(nums[l]+nums[r]==target) return new int[]{l, r};
//            else if (nums[l]+nums[r]>target) r -= 1;
//            else l += 1;
//        }
//        return null;
//    }
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i]; // 실제 값
            arr[i][1] = i; // 배열의 인덱스
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) return new int[]{arr[l][1],arr[r][1]};
            else if (nums[l] + nums[r] > target) r -= 1;
            else l += 1;
        }
        return null;
    }
}
