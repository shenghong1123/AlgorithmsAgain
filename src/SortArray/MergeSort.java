package SortArray;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] nums, int start, int end) {
        if (end - start == 1) {
            return Arrays.copyOfRange(nums, start, end);
        }
        int mid = start + (end - start) / 2;
        int[] left = sort(nums, start, mid);
        int[] right = sort(nums, mid, end);
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[n] = left[i];
                i++;
                n++;
            } else {
                result[n] = right[j];
                j++;
                n++;
            }
        }
        while (i < left.length) {
            result[n] = left[i];
            i++;
            n++;
        }
        while (j < right.length) {
            result[n] = right[j];
            j++;
            n++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] nums = {4,2,6,8,5,1,3,9,7,10};
        int[] result = ms.sort(nums, 0, nums.length - 1);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
