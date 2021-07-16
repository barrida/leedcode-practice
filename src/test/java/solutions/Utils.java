package solutions;

import java.math.BigInteger;

/**
 * @author Suleyman Yildirim
 */
public class Utils {
    public boolean isOddBigInteger(BigInteger val) {
        return !val.mod(new BigInteger("2")).equals(BigInteger.ZERO);
    }
}
