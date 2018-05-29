package Sorting;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] nums = {4,2,6,8,5,1,3,9,7,10};
        hs.sort(nums);
        for (int i : nums) System.out.println(i);
    }

    public void sort(int[] nums) {

        for (int i = nums.length / 2 - 1; i >= 0; i--)                                                               {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
    }
    /*
    n: size
    i: start
     */
    public void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && nums[left] > nums[largest]) largest = left;
        if (right < n && nums[right] > nums[largest]) largest = right;
        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, n, largest);
        }
    }
}
