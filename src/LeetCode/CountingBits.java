package LeetCode;

public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 0; i < num + 1; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        int[] result = solution.countBits(5);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
