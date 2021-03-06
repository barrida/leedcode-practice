package solutions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.*;

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
        System.out.println(Solutions.checkIfExist(new int[]{2, 5, 7}));
        System.out.println(Solutions.checkIfExist(new int[]{2, 1, 5}));
        System.out.println(Solutions.checkIfExistWithStreamApi(new int[]{2, 1, 5}));
    }

    @Test
    public void removeDuplicatesFromSortedArray() {
        assertEquals(5, Solutions.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        assertEquals(2, Solutions.removeDuplicates(new int[]{1, 1, 1, 2}));
    }

    @Test
    public void findMaxConsecutiveOnes() {
        assertEquals(3, Solutions.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }


    @Test
    public void findEvenNumberOfDigits() {
        assertEquals(2, Solutions.findEvenNumberOfDigits(new int[]{12, 345, 2, 6, 7896}));
    }

    @Test
    public void sortedSquares() {
        int[] actual = Solutions.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        int[] expected = {0, 1, 9, 16, 100};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void sortedSquaresWithoutArraysSort() {
        int[] actual = Solutions.sortedSquaresWithoutArraysSort(new int[]{-6, -4, 1, 2, 3, 5});
        int[] expected = {1, 4, 9, 16, 25, 36};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void mergeSortedArraysNaive() {
        int[] sortedArray = Solutions.mergeSortedArraysNaive(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        int[] expected = {1, 2, 2, 3, 5, 6};
        assertEquals(Arrays.toString(expected), Arrays.toString(sortedArray));
    }

    @Test
    public void mergeSortedNonArraysWithTwoIndex() {
        int[] sortedArray = Solutions.mergeSortedArrays(new int[]{1, 3, 4, 5}, 4, new int[]{2, 4, 6, 8}, 4);
        int[] expected = {1, 2, 3, 4, 4, 5, 6, 8};
        assertEquals(Arrays.toString(expected), Arrays.toString(sortedArray));

        int[] sortedArray2 = Solutions.mergeSortedArrays(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        int[] expected2 = {1, 2, 2, 3, 5, 6};
        assertEquals(Arrays.toString(expected2), Arrays.toString(sortedArray2));

        int[] sortedArray3 = Solutions.mergeSortedArrays(new int[]{}, 0, new int[]{2, 5, 6}, 3);
        int[] expected3 = {2, 5, 6};
        assertEquals(Arrays.toString(expected3), Arrays.toString(sortedArray3));

        int[] sortedArray4 = Solutions.mergeSortedArrays(new int[]{2, 0}, 1, new int[]{1}, 1);
        int[] expected4 = {1, 2};
        assertEquals(Arrays.toString(expected4), Arrays.toString(sortedArray4));

        int[] sortedArray5 = Solutions.mergeSortedArrays(new int[]{2, 5, 6}, 3, new int[]{}, 0);
        int[] expected5 = {2, 5, 6};
        assertEquals(Arrays.toString(expected5), Arrays.toString(sortedArray5));

        int[] sortedArray6 = Solutions.mergeSortedArrays(new int[]{1}, 1, new int[]{}, 0);
        int[] expected6 = {1};
        assertEquals(Arrays.toString(expected6), Arrays.toString(sortedArray6));

    }

    @Test
    public void replaceElementsWithGreatestElementOnRightSide() {
        assertEquals("[-1]", Arrays.toString(Solutions.replaceElements(new int[]{400})));
        assertEquals("[18, 6, 6, 6, 1, -1]", Arrays.toString(Solutions.replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }

    @Test
    public void moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        assertEquals("[1, 3, 12, 0, 0]", Arrays.toString(Solutions.moveZeroes(nums)));
        assertEquals("[1, 3, 12, 0, 0]", Arrays.toString(Solutions.moveZeroesWithStreamsApi(nums)));
    }

    @Test
    public void sortArrayByParity() {
        int[] nums = {3, 1, 2, 4};
        assertEquals("[2, 4, 3, 1]", Arrays.toString(Solutions.sortArrayByParity(nums)));
        assertEquals("[4, 2, 1, 3]", Arrays.toString(Solutions.sortArrayByParityInPlace(nums)));
    }

    @Test
    public void maxSubArray() {
        assertEquals(11, Solutions.maxSubArray(new int[]{6, 3, 1, -7, 8}));
        assertEquals(9, Solutions.maxSubArray(new int[]{6, 3, -10, -7, 8}));
        assertEquals(25, Solutions.maxSubArray(new int[]{6, 3, 1, 7, 8}));
        assertEquals(6, Solutions.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(23, Solutions.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        assertEquals(1, Solutions.maxSubArray(new int[]{1}));
        assertEquals(-1, Solutions.maxSubArray(new int[]{-5, -4, -1, -7, -8}));
    }

    @Test
    public void fixReverseDigitsSolutionBug() {
        assertEquals("7885574", Solutions.fixReverseDigitsSolutionBug(4755887));
        assertEquals("97531", Solutions.fixReverseDigitsSolutionBug(13579));
        assertEquals("10011", Solutions.fixReverseDigitsSolutionBug(11001));
        assertEquals("1", Solutions.fixReverseDigitsSolutionBug(10000));
        assertEquals("11001", Solutions.fixReverseDigitsSolutionBug(100110));
    }

    @Test
    public void soldierRank() {
        assertEquals(5, Solutions.soldierRank(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0}));
        assertEquals(0, Solutions.soldierRank(new int[]{4, 2, 0}));
        assertEquals(3, Solutions.soldierRank(new int[]{4, 4, 3, 3, 1, 0}));
    }
}