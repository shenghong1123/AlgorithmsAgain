package LeetCode;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
