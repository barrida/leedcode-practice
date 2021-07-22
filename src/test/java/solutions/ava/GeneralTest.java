package solutions.ava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import solutions.Solutions;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Suleyman Yildirim
 */
@RunWith(MockitoJUnitRunner.class)
public class GeneralTest {

    @Test
    public void fibionacciSum() {
        assertEquals(2, General.sumOfEvenFibonacci(3).intValue());
        assertEquals(10, General.sumOfEvenFibonacci(6).intValue());
        assertEquals(10, General.sumOfEvenFibonacci(7).intValue());
        assertEquals(10, General.sumOfEvenFibonacci(8).intValue());
        assertEquals(188, General.sumOfEvenFibonacci(13).intValue());
        assertEquals(new BigInteger("286573922006908542050"), General.sumOfEvenFibonacci(100));
    }

    /**
     * Write a function in a language of your choice which, when passed a positive integer returns
     * true if the decimal representation of that integer contains no odd digits and otherwise returns
     * false.
     */
    @Test
    public void noOddDigits() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> General.isOddDigits(-5));
        assertTrue(General.isOddDigits(0)); // 0*1
        assertFalse(General.isOddDigits(125)); // 5*1 + 2*10 + 1*100
        assertTrue(General.isOddDigits(100)); // 0*1 + 0*10 + 1*100
        assertTrue(General.isOddDigits(30)); // 0*1 + 3*10
        assertFalse(General.isOddDigits(23)); // 3*1 + 2*10
    }

    /**
     * Write a function in a language of your choice which, when passed a decimal digit X, returns the
     * value of X+XX+XXX+XXXX. E.g. if the supplied digit is 3 it should return 3702
     * (3+33+333+3333).
     */
    @Test
    public void sumOfDecimalDigit() throws Exception {
        //assertThrows(IllegalArgumentException.class, () -> General.noOddDigits(-5));
        assertEquals(BigInteger.valueOf(3702), General.getSumOfDecimalDigit(3));
    }

    @Test
    public void findDuplicatedFromSortedArray() {
        assertEquals("[2, 5, 7, 8]", Arrays.toString(General.findDuplicatedFromSortedArray(new int[]{2, 2, 5, 7, 8, 13, 14}, new int[]{1, 2, 3, 5, 7, 8}))
        );
    }

}