package yichenliang.leetcode.withoutTopic;

/**
 * 717. 1-bit and 2-bit Characters
 */
class OneBitAndTwoBitCharacters {
    /**
     * @param bits array consist of 0 and 1, length between 1 to 1000
     * @return whether the last character must be a one-bit character or not.
     */
    boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0) { return false; }
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                if (i < bits.length - 1 && (bits[i + 1] == 1 || bits[i + 1] == 0)) {
                    i++;
                }
            } else if (bits[i] == 0 && i == bits.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Increment Pointer
     * @param bits array consist of 0 and 1, length between 1 to 1000
     * @return whether the last character must be a one-bit character or not.
     */
    boolean isOneBitCharacterAlt(int[] bits) {

        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;   //!!!  when bits[i] == 1: jump two steps; when bits[i] == 0: jump one step
        }
        return i == bits.length - 1;
    }
}

