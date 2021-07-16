package solutions.ava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author Suleyman Yildirim
 */
@RunWith(MockitoJUnitRunner.class)
public class BalancedStackTest {

    @Test
    public void isBalanced(){
        BalancedStack stack = new BalancedStack();
        assertTrue(stack.isBalanced("{[(())]()}"));
        assertFalse(stack.isBalanced("{[(()])()}"));
    }
}