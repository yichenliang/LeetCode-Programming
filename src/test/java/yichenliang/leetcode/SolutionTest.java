package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private OneBitAndTwoBitCharacters solution;

    @BeforeEach
    void beforeEach() {
        solution = new OneBitAndTwoBitCharacters();
    }

    @Test
    void isOneBitCharacter() {
        Assertions.assertTrue(solution.isOneBitCharacter(new int[] { 1, 0, 0 }));
        Assertions.assertFalse(solution.isOneBitCharacter(new int[] { 1, 1, 1, 0 }));
        Assertions.assertTrue(solution.isOneBitCharacter(new int[] { 0, 0 }));
    }

    @Test
    void isOneBitCharacterAlt() {
        Assertions.assertTrue(solution.isOneBitCharacterAlt(new int[] { 1, 0, 0 }));
        Assertions.assertTrue(solution.isOneBitCharacter(new int[] { 0, 0 }));
        Assertions.assertTrue(solution.isOneBitCharacterAlt(new int[] { 0, 0 }));
    }
}
