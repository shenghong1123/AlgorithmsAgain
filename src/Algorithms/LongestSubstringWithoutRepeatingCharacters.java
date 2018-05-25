package Algorithms;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int result = Integer.MIN_VALUE;
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = -1;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                start = Math.max(start, map.get(array[i]));
            }
            result = Math.max(result, i - start);
            map.put(array[i], i);
        }
        return result;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
