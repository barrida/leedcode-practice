package solutions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author Suleyman Yildirim
 */
@RunWith(MockitoJUnitRunner.class)
public class SolutionsTest {

    @Before
    public void setUp() {
    }

    @Test
    public void checkIfExist() {
    }

    @Test
    public void checkIfExistWithStreamApi() {
    }

    @Test
    public void removeDuplicates() {
    }

    @Test
    public void isPalindromeWithStringBuilder() {
    }

    @Test
    public void isPalindromeWithArray() {
    }

    @Test
    public void findMaxConsecutiveOnes(){
        assertEquals(3,Solutions.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    @Test
    public void makingAnagrams(){
        assertEquals(3, Solutions.makingAnagrams("cdea", "abc"));
        assertEquals(6, Solutions.makingAnagrams("abc", "amnop"));
        assertEquals(19, Solutions.makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj", "djfladfhiawasdkjvalskufhafablsdkashlahdfa"));
    }

    @Test
    public void findEvenNumberOfDigits(){
        assertEquals(2,Solutions.findEvenNumberOfDigits(new int[]{12,345,2,6,7896}));
    }

    @Test
    public void sortedSquares(){
        int[] actual = Solutions.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        int[] expected = {0, 1, 9, 16, 100};
        assertEquals(Arrays.toString(expected),Arrays.toString(actual));
    }

    @Test
    public void sortedSquaresWithoutArraysSort(){
        int[] actual = Solutions.sortedSquaresWithoutArraysSort(new int[]{-6, -4, 1, 2, 3, 5});
        int[] expected = {1, 4, 9, 16, 25, 36};
        assertEquals(Arrays.toString(expected),Arrays.toString(actual));
    }

    @Test
    public void mergeSortedArraysNaive(){
        int[] sortedArray = Solutions.mergeSortedArraysNaive(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
        int[] expected = {1,2,2,3,5,6};
        assertEquals(Arrays.toString(expected),Arrays.toString(sortedArray));
    }

    @Test
    public void mergeSortedNonArraysWithTwoIndex(){
        int[] sortedArray = Solutions.mergeSortedArrays(new int[] {1,3,4,5}, 4, new int[] {2,4,6,8}, 4);
        int[] expected = {1,2,3,4,4,5,6,8};
        assertEquals(Arrays.toString(expected),Arrays.toString(sortedArray));

        int[] sortedArray2 = Solutions.mergeSortedArrays(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
        int[] expected2 = {1,2,2,3,5,6};
        assertEquals(Arrays.toString(expected2),Arrays.toString(sortedArray2));

        int[] sortedArray3 = Solutions.mergeSortedArrays(new int[] {}, 0, new int[] {2,5,6}, 3);
        int[] expected3 = {2,5,6};
        assertEquals(Arrays.toString(expected3),Arrays.toString(sortedArray3));

    }

}