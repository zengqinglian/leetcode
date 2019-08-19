package swapForLongestRepeatedCharacterSubstring;

public class Solution {
    // 11ms solution , beat 30%
    public int maxRepOpt1(String text) {
	Node[][] dp = new Node[26][2];
	int max = 0;

	for (int i = 0; i < text.length(); i++) {
	    char c = text.charAt(i);
	    int idx = c - 'a';
	    Node[] val = dp[idx];
	    if (val[0] == null) {
		Node node = new Node(i, i);
		dp[idx][0] = node;
		node.cnt = 1;
	    } else {
		if (dp[idx][0].lastIndex == i - 1) {
		    dp[idx][0].lastIndex = i;
		} else {
		    if (dp[idx][1] == null) {
			Node node = new Node(i, i);
			dp[idx][1] = node;
			max = Math.max(1 + (dp[idx][0].lastIndex - dp[idx][0].startIndex + 1), max);
			node.cnt = dp[idx][0].cnt + 1;
		    } else {
			if (dp[idx][1].lastIndex == i - 1) {
			    dp[idx][1].lastIndex = i;
			} else {
			    if(dp[idx][1].startIndex - dp[idx][0].lastIndex == 2) {
				if (dp[idx][1].cnt >= 2) {
				    max = Math.max(max, dp[idx][1].lastIndex - (dp[idx][1].startIndex) + 1
					    + (dp[idx][0].lastIndex - dp[idx][0].startIndex + 1) + 1);
				} else {
				    max = Math.max(max, dp[idx][1].lastIndex - (dp[idx][1].startIndex) + 1
					    + (dp[idx][0].lastIndex - dp[idx][0].startIndex + 1));
				}
			    }else {
				max = Math.max(max, dp[idx][1].lastIndex - (dp[idx][1].startIndex) + 2);
			    }

			    dp[idx][0] = dp[idx][1];
			    Node node = new Node(i, i);
			    dp[idx][1] = node;
			    node.cnt = dp[idx][0].cnt + 1;
			}
		    }
		}
	    }
	}
	for (Node[] node : dp) {
	    if (node[0] == null) {
		continue;
	    }
	    if (node[1] == null) {
		max = Math.max(node[0].lastIndex - node[0].startIndex + 1, max);
	    } else {
		if (node[1].startIndex - node[0].lastIndex == 2) {
		    if (node[1].cnt >= 3) {
			max = Math.max(max, node[1].lastIndex - node[1].startIndex + 1
				+ (node[0].lastIndex - node[0].startIndex + 1) + 1);
		    } else {
			max = Math.max(max, node[1].lastIndex - node[1].startIndex + 1
				+ (node[0].lastIndex - node[0].startIndex + 1));
		    }
		} else {
		    max = Math.max(max, node[1].lastIndex - node[1].startIndex + 2);
		}
	    }
	}
	return max;
    }

    private static class Node {
	private int startIndex;
	private int lastIndex;
	private int cnt = 0;

	public Node(int startIndex, int lastIndex) {
	    this.startIndex = startIndex;
	    this.lastIndex = lastIndex;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.maxRepOpt1("babbaaabbbbbaa");
    }
}
