/**
 * @author Suleyman Yildirim
 */

package solutions;

public class LeetcodePracticeApplication {

    public static void main(String[] args) {
        System.out.println(Solutions.checkIfExist(new int[]{2, 5, 7}));
        System.out.println(Solutions.checkIfExist(new int[]{2, 1, 5}));
        System.out.println(Solutions.checkIfExistWithStreamApi(new int[]{2, 1, 5}));
        System.out.println(Solutions.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(Solutions.removeDuplicates(new int[]{1, 1, 1, 2}));
        System.out.println(Solutions.isPalindromeWithStringBuilder("A man, a plan, a canal: Panama"));
        System.out.println(Solutions.isPalindromeWithArray("A man, a plan, a canal: Panama"));
        System.out.println(Solutions.isPalindromeWithStringBuilder("race a car"));
        System.out.println(Solutions.isPalindromeWithArray("race a car"));
    }


}
