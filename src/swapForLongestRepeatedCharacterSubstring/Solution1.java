package swapForLongestRepeatedCharacterSubstring;

public class Solution1 {
    // someone's 3ms solution , beat 99%
    public int maxRepOpt1(String text) {
	int[] freq = new int[26];
	int[] counts = new int[26];
	int most = 0, max = 0;
	char[] ns = text.toCharArray();
	for (char c : ns)
	    counts[c - 'a']++;
	for (int l = 0, r = 0; r < ns.length; r++) {
	    most = Math.max(most, ++freq[ns[r] - 'a']);
	    while (r - l > most || r - l > counts[ns[l] - 'a'] - 1) {
		freq[ns[l++] - 'a']--;
	    }
	    max = Math.max(max, r - l + 1);
	}
	return max;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.maxRepOpt1("ababa");
    }
}
