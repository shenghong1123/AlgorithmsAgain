package LeetCode;

public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < n; i++) {
            upper *= 10;
            upper += 9;
        }
        lower = 1 + upper / 10;

        int max = 0;
        for (int i = lower; i <= upper; i++) {
            for (int j = i; j <= upper; j++) {
                if (isPalindrome(i * j) && i * j > max) {
                    max = i * j;
                }
            }
        }
        return max;
    }

    public boolean isPalindrome(int x) {
        int temp = x;
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return temp == result;
    }

    public static void main(String[] args) {
        LargestPalindromeProduct solution = new LargestPalindromeProduct();
        System.out.println(solution.largestPalindrome(2));
    }
}
