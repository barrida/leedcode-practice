/**
 * @author Suleyman Yildirim
 */

package solutions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Solution.checkIfExist(new int[]{2, 5, 7}));
        System.out.println(Solution.checkIfExist(new int[]{2, 1, 5}));
        System.out.println(Solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(Solution.removeDuplicates(new int[]{1,1,1,2}));
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

    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        System.out.println("start: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length -1 ; i++) {
            if (nums[i + 1] != nums[i]){
                nums[++unique] = nums[i + 1];
            }
        }
        System.out.println("end: "+Arrays.toString(nums));
        return ++unique;
    }

}
