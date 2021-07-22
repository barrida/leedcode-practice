package solutions;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Suleyman Yildirim
 */
public class StringAlgorithms {
    private StringAlgorithms() {
    }

    public static boolean isPalindromeWithStringBuilder(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equalsIgnoreCase(s);
    }

    public static boolean isPalindromeWithArray(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[chars.length - i - 1] != chars[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given two strings,  and , that may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams.
     * Any characters can be deleted from either of the strings.
     *
     * @param s1 string s1: a string
     * @param s1 string s2: a string
     * @return the minimum number of deletions needed
     */
    public static int makingAnagrams(String s1, String s2) {
        int[] chars1Frequency = new int[26];
        int[] chars2Frequency = new int[26];

        getFrequency(s1.toCharArray(), chars1Frequency);
        getFrequency(s2.toCharArray(), chars2Frequency);

        return IntStream.range(0, 26)
                .map(i -> Math.abs(chars1Frequency[i] - chars2Frequency[i]))
                .sum();
    }

    private static void getFrequency(char[] chars, int[] charsFrequency) {
        for (char value : chars) {
            int positionCurrentChar = Character.getNumericValue(value) - Character.getNumericValue('a');
            charsFrequency[positionCurrentChar]++;
        }
    }


    /**
     * @param s
     * @return
     * @todo unfinished
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 1;
        int i = 0;
        int j = 1;
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        while (j < s.length()) {
            if (chars[j] != s.charAt(i)) {
                j++;
            } else if (res <= s.substring(i, j).length()) {
                // res = Math.max(res,s.substring(i,j).length());
                res = s.substring(i, j).length();
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}
