package zumaGame;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // wrong solution
    public int findMinStep(String board, String hand) {
        int[][][] result = new int[board.length()][board.length()][board.length()];
        Map<Character, Integer> hMap = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (hMap.containsKey(c)) {
                hMap.put(c, hMap.get(c) + 1);
            } else {
                hMap.put(c, 1);
            }
        }
        int min = dfs(result, board, hMap, 0, board.length() - 1, 0);
        return min;
    }

    private int dfs(int[][][] result, String board, Map<Character, Integer> hMap, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        
        if (result[l][r][k] > 0) {
            return result[l][r][k];
        }

        Map<Character, Integer> tempMap = new HashMap<>(hMap);

        // WWRR.....RW
        // case 1: find WW, remove it first
        while (l < r && board.charAt(l) == board.charAt(l + 1)) {
            l++;
            k++;
        }

        Map<Character, Integer> case1Map = new HashMap<>();
        Character tempKey = null;
        if (k + 1 >= 3) {
            result[l][r][k] = dfs(result, board, hMap, l + 1, r, 0);
        } else if (hMap.containsKey(board.charAt(l)) && hMap.get(board.charAt(l)) + k + 1 >= 3) {
            case1Map.put(board.charAt(l), hMap.get(board.charAt(l)));
            tempKey = board.charAt(l);
            hMap.put(board.charAt(l), hMap.get(board.charAt(l)) - 3 + k + 1);
            int remain = dfs(result, board, hMap, l + 1, r, 0);
            if (remain != -1) {
                result[l][r][k] = 3 - (k + 1) + remain;
            } else {
                result[l][r][k] = -1;
            }
        } else {
            result[l][r][k] = -1;
        }

        // Case 2: link right hand W and remove middle part first
        for (int i = r; i > l; i--) {
            if(board.charAt(i)==board.charAt(l)){
                int r1 = dfs(result, board, tempMap, l + 1, i - 1, 0);
                int r2 = dfs(result, board, tempMap, i, r, k + 1);
                if (r1 == -1 || r2 == -1) {
                    continue;
                } else if (result[l][r][k] == -1 || result[l][r][k] > r1 + r2) {
                    result[l][r][k] = r1 + r2;
                    if (tempKey != null) {
                        hMap.put(tempKey, case1Map.get(tempKey));
                    }
                }
            }
        }

        return result[l][r][k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "GYGGYYRRYGGYR"
        // "GYGYY"

        // GYGGYY - GYY

        // "RGGBYRRYWWYYBBGRGG"
        // "RRYWG"
        s.findMinStep("RGGBYRRYWWYYBBGRGG", "RRYWG");
    }

}
