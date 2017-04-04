package zumaGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    // fomular F(n) = F(n-1) + cost of Ball
    public int findMinStep(String board, String hand) {
        List<Character> boards = new ArrayList<>();
        for (char c : board.toCharArray()) {
            boards.add(c);
        }
        Map<Character, Integer> hands = new HashMap<>();
        hands.put('R', 0);
        hands.put('Y', 0);
        hands.put('B', 0);
        hands.put('G', 0);
        hands.put('W', 0);
        for (char h : hand.toCharArray()) {
            hands.put(h, hands.get(h) + 1);
        }
        return find(boards, hands);
    }

    public int find(List<Character> boards, Map<Character, Integer> hands) {
        clearBoard(boards);
        if (boards.size() <= 0) {
            return 0;
        }
        if (empty(hands)) {
            return -1;
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < boards.size(); i++) {
            Character c = boards.get(i);
            count++;
            if (i >= boards.size() - 1 || boards.get(i + 1) != c) {
                int need = 3 - count;
                if (hands.get(c) >= need) {
                    List<Character> small = new ArrayList<>(boards);
                    for (int j = 0; j < count; j++) {
                        small.remove(i - j);
                    }
                    hands.put(c, hands.get(c) - need);
                    int smallerFind = find(small, hands);
                    if (smallerFind > -1) {
                        min = Math.min(min, smallerFind + need);
                    }
                    hands.put(c, hands.get(c) + need);
                }
                count = 0;
            }

        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private void clearBoard(List<Character> board) {
        int count = 0;
        boolean cleaned = false;
        for (int i = 0; i < board.size(); i++) {
            char c = board.get(i);
            count++;
            if (i == board.size() - 1 || board.get(i + 1) != c) {
                if (count >= 3) {
                    for (int j = 0; j < count; j++) {
                        board.remove(i - j);
                    }
                    cleaned = true;
                    break;
                }
                count = 0;
            }
        }
        if (cleaned) {
            clearBoard(board);
        }
    }

    private boolean empty(Map<Character, Integer> hand) {
        for (int val : hand.values()) {
            if (val > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        // "GYGGYYRRYGGYR"
        // "GYGYY"

        // GYGGYY - GYY

        // "RGGBYRRYWWYYBBGRGG"
        // "RRYWG"
        s.findMinStep("RGGBYRRYWWYYBBGRGG", "RRYWG");
    }
}
