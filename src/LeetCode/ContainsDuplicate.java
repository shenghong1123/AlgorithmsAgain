package LeetCode;
import java.util.*;

/*
Return true if there exist duplicate numbers
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,6};
        ContainsDuplicate solution = new ContainsDuplicate();
        System.out.println(solution.containsDuplicate(nums));
    }
}
