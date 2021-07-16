package solutions.ava;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Suleyman Yildirim
 */
public class BalancedStack {


    /**
     * Write a Java function which, when passed a string containing a mixture of bracket characters -
     * i.e. ‘{‘, ‘}’, ‘[‘, ‘]’, ‘(‘ and ‘)’, returns true if the brackets in the string are correctly balanced, and
     * false otherwise. E.g. when called with “{[(())]()}” it should return true, but “{[(()])()}” should
     * return false. Non-bracket characters in the string should be ignored.
     */

    public boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (isOpeningBracket(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (isMatchWithOpeningBracket(stack, c, ')', '(') ||
                    isMatchWithOpeningBracket(stack, c, '}', '{') ||
                    isMatchWithOpeningBracket(stack, c, ']', '[')) {
                stack.pop();
            }
        }
        return stack.isEmpty();

    }

    private boolean isMatchWithOpeningBracket(Deque<Character> stack, char currentCharacter, char closingCharacter, char openingCharacter) {
        return (currentCharacter == closingCharacter) && (stack.peek() == openingCharacter);
    }

    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

}
