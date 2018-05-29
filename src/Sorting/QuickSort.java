package Sorting;

public class QuickSort {

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = partition(nums, start, end);
        sort(nums, start, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = {4,2,6,8,5,1,3,9,7,10};
        qs.sort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
