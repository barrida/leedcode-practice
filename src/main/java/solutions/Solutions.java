package solutions;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Suleyman Yildirim
 */
public class Solutions {
    private Solutions() {
    }

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
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                nums[++unique] = nums[i + 1];
            }
        }

        System.out.println(Arrays.toString(nums));
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
     *
     * @param ints
     * @return
     */
    public static int findEvenNumberOfDigits(int[] ints) {

        int result = 0;
        for (int num : ints) {
            int digits = 0;
            while (num != 0) {
                num = num / 10;
                digits++;
            }

            if (digits % 2 == 0)
                result++;
        }

        return result;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        IntStream.range(0, nums.length)
                .forEach(i -> nums[i] *= nums[i]);
        Arrays.sort(nums);
        return nums;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquaresWithoutArraysSort(int[] nums) {
        int positiveIndex = nums.length - 1;
        int negativeIndex = 0;
        int[] output = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[negativeIndex]) > Math.abs(nums[positiveIndex])) {
                output[i] = nums[negativeIndex] * nums[negativeIndex];
                negativeIndex++;
            } else {
                output[i] = nums[positiveIndex] * nums[positiveIndex];
                positiveIndex--;
            }
        }

        return output;
    }

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array
     * <p>
     * Create 2 pointers for num1 and num2
     * If num1 < num2 insert num1 to sorted array and increase num1 pointer
     * otherwise insert num1 to sorted array and increase num2 pointer
     * Time Complexity O(n+m)
     * Space Complexity O(n+m)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {

        int[] sorted = new int[m + n];
        int mIndex = 0;
        int nIndex = 0;
        int indexSortedArr = 0;
        if (m == 0 && n != 0) {
            return nums2;
        } else {
            if (m != 0 && n == 0) {
                return nums1;
            } else {
                while (mIndex < m) {
                    if (nIndex == n) {
                        if (nums1[mIndex] > nums2[nIndex - 1]) {
                            sorted[indexSortedArr] = nums1[mIndex];
                            return sorted;
                        }
                    } else if (nums1[mIndex] <= nums2[nIndex]) {
                        sorted[indexSortedArr++] = nums1[mIndex++];
                    } else {
                        sorted[indexSortedArr++] = nums2[nIndex++];
                    }
                }

                for (int i = nIndex; i < n; i++) {
                    sorted[indexSortedArr++] = nums2[i];
                }
                return sorted;
            }
        }

    }

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array
     * <p>
     * Naive solution:
     * Create a new array from nums1 and nums2, then sort it.
     * <p>
     * Time Complexity (n+m) log(n+m)
     * Space Complexity O(n+m)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] mergeSortedArraysNaive(int[] nums1, int m, int[] nums2, int n) {

        int[] sorted = new int[m + n];
        int j = 0;

        for (int i = 0; i < nums1.length; i++) {
            sorted[i] = nums1[i];
            if (sorted[i] == 0) {
                sorted[i] = nums2[j];
                j++;
            }
        }

        Arrays.sort(sorted);
        return sorted;

    }

    /**
     * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
     * <p>
     * After doing so, return the array.
     *
     * @param arr
     * @return
     */
    public static int[] replaceElements(int[] arr) {
        int max = 0;
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (j == i + 1 || arr[j] > max) max = arr[j];
            }
            arr[i] = max;
        }

        arr[arr.length - 1] = -1;
        return arr;

    }

    /**
     * Time Complexity: O(N), where N is the length of nums.
     * <p>
     * Space Complexity: O(1), the space used by the answer.
     *
     * @param nums
     * @return
     */
    public static int[] moveZeroes(int[] nums) {
        int pointerOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointerOnes++] = nums[i];
            }
        }
        for (int i = pointerOnes; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    /**
     * Time Complexity: O(N), where N is the length of nums.
     * <p>
     * Space Complexity: O(1), the space used by the answer.
     *
     * @param nums
     * @return
     */
    public static int[] moveZeroesWithStreamsApi(int[] nums) {
        AtomicInteger pointerOnes = new AtomicInteger();
        IntStream.range(0, nums.length)
                .filter(i -> nums[i] != 0)
                .forEach(i -> nums[pointerOnes.getAndIncrement()] = nums[i]);

        IntStream.range(pointerOnes.get(), nums.length)
                .forEach(i -> nums[i] = 0);
        return nums;
    }

    /**
     * Time Complexity: O(N), where N is the length of A.
     * <p>
     * Space Complexity: O(N), the space used by the answer.
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParity(int[] nums) {
        int evenCounter = 0;
        int[] res = new int[nums.length];

        for (int num : nums) {
            if (num % 2 == 0) {
                res[evenCounter++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 != 0) {
                res[evenCounter++] = num;
            }
        }
        return res;
    }

    /**
     * We'll maintain two pointers i and j. The loop invariant is everything below i has parity 0 (ie. A[k] % 2 == 0 when k < i), and everything above j has parity 1.
     * <p>
     * Then, there are 4 cases for (A[i] % 2, A[j] % 2):
     * <p>
     * If it is (0, 1), then everything is correct: i++ and j--.
     * <p>
     * If it is (1, 0), we swap them so they are correct, then continue.
     * <p>
     * If it is (0, 0), only the i place is correct, so we i++ and continue.
     * <p>
     * If it is (1, 1), only the j place is correct, so we j-- and continue.
     * <p>
     * Throughout all 4 cases, the loop invariant is maintained, and j-i is getting smaller. So eventually we will be done with the array sorted as desired.
     *
     * @param A
     * @return
     * @// TODO: 29/04/2021 check later
     */
    public static int[] sortArrayByParityInPlace(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    /**
     * @param s
     * @return
     * @todo unfinished
     */
    public static int lengthOfLongestSubstring(String s) {
        // "abcabcbb"
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

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     * <p>
     * Solved using Kadane's Algorithm: https://en.wikipedia.org/wiki/Maximum_subarray_problem
     * <p>
     * <p>
     * maxSubArray(numbers):
     * """Find the largest sum of any contiguous subarray."""
     * best_sum = Integer.MIN_VALUE
     * current_sum = 0
     * for x in numbers:
     * current_sum = max(x, current_sum + x)
     * best_sum = max(best_sum, current_sum)
     * return best_sum
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;
        for (int x : nums) {
            currentSum = Math.max(x, currentSum + x);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }

    public static int soldierRank(int[] ranks) {
        int result = 0;
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int rank : ranks) {
            if (!map.containsKey(rank)) {
                map.put(rank, 1);
            } else {
                Integer count = map.get(rank);
                map.put(rank, ++count);
            }
        }
        for (Map.Entry<Integer, Integer> rank : map.entrySet()) {
            Map.Entry<Integer, Integer> prev = map.lowerEntry(rank.getKey());
            if (prev != null && rank.getKey() == prev.getKey() + 1) {
                result += prev.getValue();
            }
        }
        return result;
    }

    public void reverseDigitsSolutionWithBug(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            } else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    public static String fixReverseDigitsSolutionBug(int N) {
        String s = "";
        int enable_print = 0;
        while (N > 0) {
            if (N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                s += Integer.toString(N % 10);
            }
            N = N / 10;
        }
        return s;
    }
}
