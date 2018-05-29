package Algorithms;
import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < nums[i]) list.add(nums[i]);
            else {
                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (list.get(mid) >= nums[i]) end = mid;
                    else start = mid + 1;
                }
                list.set(start, nums[i]);
            }
        }
        System.out.println(list);
        return list.size();
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,4};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
