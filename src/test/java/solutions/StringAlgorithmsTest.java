package solutions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author Suleyman Yildirim
 */
@RunWith(MockitoJUnitRunner.class)
public class StringAlgorithmsTest {

    @Test
    public void isPalindromeWithStringBuilder() {
        assertTrue(StringAlgorithms.isPalindromeWithStringBuilder("abcdcba"));
    }

    @Test
    public void isPalindromeWithArray() {
        assertTrue(StringAlgorithms.isPalindromeWithArray("abcdcba"));
    }

    @Test
    public void makingAnagrams() {
        assertEquals(3, StringAlgorithms.makingAnagrams("cdea", "abc"));
        assertEquals(6, StringAlgorithms.makingAnagrams("abc", "amnop"));
        assertEquals(19, StringAlgorithms.makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj", "djfladfhiawasdkjvalskufhafablsdkashlahdfa"));
    }


    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(3, StringAlgorithms.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, StringAlgorithms.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, StringAlgorithms.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, StringAlgorithms.lengthOfLongestSubstring(""));
    }
}