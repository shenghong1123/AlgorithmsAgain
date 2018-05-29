package Algorithms;
import java.util.*;

public class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) return 0;
        str = str.trim();
        int sign = 1;
        int i = 0;
        if (str.charAt(i) == '+') i++;
        else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        long num = 0;
        for (;i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') break;
            num = num * 10 + (c - '0');
            System.out.println(num);
            if ((int)num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if ((int)num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int)num * sign;
    }

    public static void main(String[] args) {
        Atoi solution = new Atoi();
        System.out.println(solution.myAtoi("42"));
    }
}
