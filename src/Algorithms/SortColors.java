package Algorithms;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0;
        int j = nums.length - 1;
        int index = 0;
        while (index <= j) {
            if (nums[index] == 2) {
                nums[index] = nums[j];
                nums[j] = 2;
                j--;
            }
            else if (nums[index] == 0) {
                nums[index] = nums[i];
                nums[i] = 0;
                i++;
                index++; // now the index must not be 2, so it's safe to go ahead
            }
            else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        int[] nums2 = {0,0,1,0};
        solution.sortColors(nums2);
        for (int i : nums2) {
            System.out.println(i);
        }
    }
}
