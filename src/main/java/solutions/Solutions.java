package solutions;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Suleyman Yildirim
 */
public class Solutions {

    public static boolean checkIfExist(int[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            for (int j = 0; j < arr.length; j++) {
                if ((idx != j) && (arr[idx] == 2 * arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfExistWithStreamApi(int[] arr) {
        return IntStream.range(0, arr.length)
                .anyMatch(i -> IntStream.range(0, arr.length)
                        .anyMatch(j -> (i != j) && (arr[i] == 2 * arr[j])));
    }


    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        System.out.println("start: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                nums[++unique] = nums[i + 1];
            }
        }
        System.out.println("end: " + Arrays.toString(nums));
        return ++unique;
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

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
                maxConsecutive = Math.max(maxConsecutive, current);
            } else {
                current = 0;
            }
        }

        return maxConsecutive;
    }

    /**
     * Given two strings,  and , that may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams.
     * Any characters can be deleted from either of the strings.
     *
     * @param s1 string s1: a string
     * @param s1 string s2: a string
     *
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
     * Given an array nums of integers, return how many of them contain an even number of digits.
     * @param ints
     * @return
     */
    public static int findEvenNumberOfDigits(int[] ints) {

        int result = 0;
        for (int num: ints) {
            int digits = 0;
            while (num != 0){
                num = num / 10;
                digits++;
            }

            if (digits %2 == 0)
                result++;
        }

        return result;
    }

    /**
     *  Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        IntStream.range(0, nums.length)
                .forEach(i -> nums[i] *= nums[i]);
        Arrays.sort(nums);
        return nums;
    }
}
