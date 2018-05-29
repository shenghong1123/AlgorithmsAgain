package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] nums = {4,2,6,8,5,1,3,9,7,10};
        ss.sort(nums);
        for (int i : nums) System.out.println(i);
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;

        }
    }
}
