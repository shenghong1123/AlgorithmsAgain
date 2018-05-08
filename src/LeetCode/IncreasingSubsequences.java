package LeetCode;
import java.util.*;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            helper(nums, i + 1, list, result);
        }
        return result;
    }

    public void helper(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(list);
            return;
        }
        if (i == nums.length - 1) {
            list.add(nums[i]);
            result.add(list);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            helper(nums, j + 1, list, result);
        }
    }
}
