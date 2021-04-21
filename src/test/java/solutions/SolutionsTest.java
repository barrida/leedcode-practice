package solutions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

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
}