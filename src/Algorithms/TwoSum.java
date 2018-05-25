package Algorithms;
import java.util.*;

public class TwoSum {
    public int[] TwoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}
