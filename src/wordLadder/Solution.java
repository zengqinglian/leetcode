package wordLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // 214ms solution, beat 25%
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	Queue<String> q = new LinkedList<>();
	boolean[] visited = new boolean[wordList.size()];
	q.add(beginWord);
	int cnt = 0;

	while (!q.isEmpty()) {
	    int loop = q.size();
	    for (int i = 0; i < loop; i++) {
		String curStr = q.poll();
		if (curStr.equals(endWord)) {
		    return cnt + 1;
		} else {
		    for (int j = 0; j < wordList.size(); j++) {
			if (!visited[j] && matchCheck(curStr, wordList.get(j))) {
			    q.add(wordList.get(j));
			    visited[j] = true;
			}
		    }
		}
	    }
	    cnt++;
	}

	return 0;
    }

    private boolean matchCheck(String str1, String str2) {
	int diffcnt = 0;
	for (int i = 0; i < str1.length(); i++) {
	    if (str1.charAt(i) != str2.charAt(i)) {
		diffcnt++;
		if (diffcnt > 1) {
		    return false;
		}
	    }
	}
	return true;
    }
}
