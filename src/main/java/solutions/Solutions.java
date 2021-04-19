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
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                current++;
                maxConsecutive = Math.max(maxConsecutive,current);
            }
            else{
                current = 0;
            }
        }

        return maxConsecutive;
    }

}
