package longestAbsoluteFilePath;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 4ms solution beat 80%
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        List<Integer> length = new ArrayList<>();

        if (isFile(paths[0])) {
            return paths[0].length();
        }

        int max = -1;

        if (isFile(paths[0])) {
            max = paths[0].length();
        } else {
            length.add(paths[0].length());
        }

        for (int i = 1; i < paths.length; i++) {
            int level = getLevel(paths[i]);
            if (isFile(paths[i])) {
                if (level > 0)
                    max = Math.max(max, length.get(level - 1) + 1 - level + paths[i].length());
                else
                    max = Math.max(max, paths[i].length());
            } else {
                if (level > 0) {
                    if (level < length.size()) {
                        length.set(level, length.get(level - 1) + 1 - level + paths[i].length());
                    } else {
                        length.add(level, length.get(level - 1) + 1 - level + paths[i].length());
                    }
                } else {
                    length.set(0, paths[i].length());
                }
            }
        }


        return max;
    }

    private boolean isFile(String s) {
        return s.contains(".");
    }

    private int getLevel(String s) {
        int i = 0;
        int result = 0;
        while (s.charAt(i) == '\t') {
            result++;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lengthLongestPath("dir\n    file.txt");
    }
}
