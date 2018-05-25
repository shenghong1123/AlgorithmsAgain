package Algorithms;
import java.util.*;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : J.toCharArray()) {
            map.put(c, 1);
        }
        int result = 0;
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(solution.numJewelsInStones(J, S));
    }
}
