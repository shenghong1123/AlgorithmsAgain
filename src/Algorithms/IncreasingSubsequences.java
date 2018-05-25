package Algorithms;
import java.util.*;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        helper(nums, 0, list, set);

        return new LinkedList<>(set);
    }

    public void helper(int[] nums, int i, List<Integer> list, HashSet<List<Integer>> set) {
        if (list.size() >= 2) {
            List<Integer> copy = new LinkedList<>(list);
            set.add(copy);
        }
        if (i == nums.length) return;
        for (int j = i; j < nums.length; j++) {
            if (list.size() == 0 || (!list.isEmpty() && nums[j] >= list.get(list.size() - 1))) {
                list.add(nums[j]);
                helper(nums, j + 1, list, set);
                list.remove(list.size() - 1);
            }
        }
    }
}
