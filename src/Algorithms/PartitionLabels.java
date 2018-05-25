package Algorithms;
import java.util.*;

//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".


public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        char[] c = S.toCharArray();
        HashMap<Character, int[]> map = new HashMap<>(); // If we should hashmap to store interval???
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                map.get(c[i])[1] = i;
            }
            else {
                map.put(c[i], new int[]{i, i});
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return Integer.compare(i1[0], i2[0]);
            }
        });

        for (int[] interval : map.values()) {
            queue.add(interval);
            //System.out.println(interval[0] + " " + interval[1]);
        }
        List<Integer> result = new LinkedList<>();
        int[] curr = queue.poll();
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (interval[0] > curr[1]) {
                result.add(curr[1] - curr[0] + 1);
                curr = interval;
            } else if (interval[1] > curr[1]) {
                curr[1] = interval[1];
            }
        }
        result.add(curr[1] - curr[0] + 1);
        //System.out.println(result);
        return result;
    }
}
