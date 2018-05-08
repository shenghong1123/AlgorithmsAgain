package LeetCode;

/*
4  = 100   --> false 010 000
5  = 101   --> true 010
7  = 111   --> false
10 = 1010  --> true  0101 1111
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBitsNaive(int n) {
        int lastBit = n % 2 == 1? 0 : 1;
        while (n != 0) {
            System.out.println(lastBit);
            int bit = n % 2;
            if (lastBit == bit) return false;
            lastBit = bit;
            n /= 2;
        }
        return true;
    }

    public boolean hasAlternatingBits(int n) {
        int shift = n >> 1;
        int xor = shift ^ n;
        return (xor & xor+1) == 0;
    }

    public static void main(String[] args) {

        BinaryNumberWithAlternatingBits solution = new BinaryNumberWithAlternatingBits();

        System.out.println(solution.hasAlternatingBits(5));
    }
}
