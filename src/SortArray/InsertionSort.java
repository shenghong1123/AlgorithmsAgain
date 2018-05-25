package SortArray;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] nums = {4,2,6,8,5,1,3,9,7,10};
        is.sort3(nums, 9);
        for (int i : nums) System.out.println(i);
    }

    // faster due to less swap
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
             int key = nums[i];
             int j = i - 1;
             while (j >= 0 && key < nums[j]) {
                 nums[j + 1] = nums[j];
                 j = j - 1;
             }
             nums[j + 1] = key;
        }
    }

    public void sort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
    }

    // n = nums.length - 1
    public void sort3(int[] nums, int n) {
        if (n > 0) {
            // Use recursion to replace outer loop
            sort3(nums, n - 1);
            int key = nums[n];
            int j = n - 1;
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
}
