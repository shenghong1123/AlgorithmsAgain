package Algorithms;

import java.util.Comparator;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        System.out.println(v1.length);
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
            if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[j])) {
                i++;
                j++;
            }
            else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[j])) return -1;
            else return 1;
        }
        while (i < v1.length) {
            if (Integer.parseInt(v1[i]) != 0) return 1;
            else i++;
        }
        while (j < v2.length) {
            if (Integer.parseInt(v2[j]) != 0) return -1;
            else j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers solution = new CompareVersionNumbers();
        String version1 = "0.1";
        String version2 = "1.1";
        System.out.println(solution.compareVersion(version1, version2));
    }
}
