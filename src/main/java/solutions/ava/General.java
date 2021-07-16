package solutions.ava;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Suleyman Yildirim
 */
public class General {

    /**
     * The Fibonacci sequence is defined as a sequence of integers starting with 1 and 1, where each
     * subsequent value is the sum of the preceding two. I.e.
     * f(0) = 1
     * f(1) = 1
     * f(n) = f(n-1) + f(n-2) where n >= 2
     * Write a program in a language of your choice to calculate the sum of the first 100 even-valued
     * Fibonacci numbers
     * <p>
     * <p>
     * Fibonacci sequence appear in a pattern regarding odd and even numbers. The Fibonacci sequence is: ODD, ODD, EVEN, ODD, ODD, EVEN,
     *
     * @param n
     * @return
     */
    public static BigInteger sumOfEvenFibonacci(int n) {
        var memo = new BigInteger[n + 1];
        Arrays.fill(memo, BigInteger.valueOf(-1));
        memo[0] = BigInteger.ZERO;
        memo[1] = BigInteger.ONE;
        var result = BigInteger.ZERO;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1].add(memo[i - 2]);
            if (isEven(memo[i])) {
                result = result.add(memo[i]);
            }
        }
        return result;
    }

    private static boolean isEven(BigInteger bigInteger) {
        return bigInteger.remainder(BigInteger.TWO).equals(BigInteger.ZERO);
    }


    /**
     * Write a function in a language of your choice which, when passed a positive integer returns
     * true if the decimal representation of that integer contains no odd digits and otherwise returns
     * false.
     *
     * @param N
     * @return
     */

    public static boolean isOddDigits(int N) throws Exception {
        if (N < 0)
            throw new IllegalArgumentException("Integer must be positive");
        var steps = 0;
        while (N > 0) {
            var multiplier = N % 10;
            var digit = multiplier * Math.pow(10, steps);
            if (digit % 2.0 != 0) return false;
            N /= 10;
            steps++;
        }
        return true;
    }

    /**
     * Write a function in a language of your choice which, when passed a decimal digit x, returns the
     * value of x+XX+XXX+XXXX. E.g. if the supplied digit is 3 it should return 3702
     * (3+33+333+3333).
     */

    public static BigInteger getSumOfDecimalDigit(int x) {
        var currentDigit = BigInteger.ZERO;
        var sum = BigInteger.ZERO;
        for (int n = 0; n < 4; n++) {
            var multiplier = (long) x * (long) Math.pow(10, n);
            currentDigit = currentDigit.add(BigInteger.valueOf(multiplier));
            sum = sum.add(currentDigit);
        }
        return sum;
    }

    /**
     * Write a function in a language of your choice which, when passed two sorted arrays of integers
     * returns an array of any numbers which appear in both. No value should appear in the returned
     * array more than once.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] findDuplicatedFromSortedArray(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        var indexA = 0;
        var indexB = 0;
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] > b[indexB])
                indexB++;
            else if (a[indexA] < b[indexB])
                indexA++;
            else {
                list.add(a[indexA]);
                indexA++;
                indexB++;
            }
        }
        return list.stream().mapToInt(value -> value).toArray();
    }
}
