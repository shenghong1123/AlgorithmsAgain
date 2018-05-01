package LeetCode;
import java.util.*;
import java.lang.*;

public class MergeSort {
    public int[] MergeSort(int[] nums, int start, int end) {
        if (end - start == 1) {
            return Arrays.copyOfRange(nums, start, end);
        }
        int mid = start + (end - start) / 2;
        int[] left = MergeSort(nums, start, mid);
        int[] right = MergeSort(nums, mid, end);
        return Merge(left, right);
    }

    public int[] Merge(int[] left, int[] right) {
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
}
