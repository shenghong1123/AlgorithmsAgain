package LeetCode;
import java.util.*;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) return i;
        }
        return -1;
    }

    public int firstUniqCharTwoPointer(String s) {
        return 0;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();
        String s = "loveleetcode";
        System.out.println(solution.firstUniqChar(s));
    }
}
