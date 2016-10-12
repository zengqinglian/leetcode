package eliminationGame;

public class Solution2 {
    // 85ms soltuion - beat 50%
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2 || n == 3) {
            return 2;
        }

        boolean leftToRight = false;
        int length = n / 2;
        int first = 2;
        int gap = 2;

        return remove(n, leftToRight, length, gap, first);
    }

    private int remove(int target, boolean leftToRight, int length, int gap, int first) {
        if (length == 1) {
            return first;
        }

        if (length == 2) {
            return leftToRight ? first + gap : first;
        }

        int newLength = length / 2;
        int newGap = gap * 2;
        int newFirst = 0;
        if (length % 2 == 0 && !leftToRight) {
            newFirst = first;
        } else {
            newFirst = first + gap;
        }

        return remove(target, !leftToRight, newLength, newGap, newFirst);
    }
}
