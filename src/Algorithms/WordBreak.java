package Algorithms;
import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= s.length(); j++) {
                    if (wordDict.contains(s.substring(i, j))) dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

        WordBreak solution = new WordBreak();

        String s1 = "leetcode";
        List<String> wordDict1 = new LinkedList<>();
        wordDict1.add("leet");
        wordDict1.add("code");

        String s2 = "catsandog";
        List<String> wordDict2 = new LinkedList<>();
        wordDict2.add("cats");
        wordDict2.add("dog");
        wordDict2.add("sand");
        wordDict2.add("and");
        wordDict2.add("cat");
        System.out.println(solution.wordBreak(s2, wordDict2));
    }
}
