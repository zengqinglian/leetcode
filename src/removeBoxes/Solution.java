package removeBoxes;

public class Solution {
    // recursive solution
    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0) {
            return 0;
        }

        if (boxes.length == 1) {
            return 1;
        }

        int[][][] result = new int[boxes.length][boxes.length][boxes.length];

        return getMaxValue(boxes, result, 0, boxes.length - 1, 0);

    }

    private int getMaxValue(int[] boxes, int[][][] result, int l, int r,
            int k /* left side equal element count */) {
        // 3331... 313.. - pattern
        if (l > r) {
            return 0;
        }
        if (result[l][r][k] > 0) {
            return result[l][r][k];
        }
        // find left continuous element - and remove it first, then remove rest
        while (l < r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        } // l = 1; k=1; l=2; k=2

        result[l][r][k] = (k + 1) * (k + 1) + getMaxValue(boxes, result, l + 1, r, 0);

        // find right hand matched element and move them together
        for (int i = r; i > l; i--) {
            if (boxes[l] == boxes[i]) {
                result[l][r][k] = Math.max(result[l][r][k],
                        getMaxValue(boxes, result, l + 1, i - 1, 0) + getMaxValue(boxes, result, i, r, k + 1));
            }
        }
        return result[l][r][k];
    }
}
