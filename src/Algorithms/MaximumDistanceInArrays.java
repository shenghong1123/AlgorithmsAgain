package Algorithms;
import java.util.*;

/*
List are sorted.
Maximum distance is between two different lists
 */
public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = 10000;
        int max = -10000;
        int maxDiff = 0;

        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            maxDiff = Math.max(maxDiff, Math.max(list.get(list.size() - 1) - min, max - list.get(0)));
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(list.size() - 1));
        }
        return maxDiff;
    }
}
