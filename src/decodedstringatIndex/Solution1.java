package decodedstringatIndex;

public class Solution1 {
    public String decodeAtIndex(String S, int K) {
	long size = 0;
	int N = S.length();

	// Find size = length of decoded string
	for (int i = 0; i < N; ++i) {
	    char c = S.charAt(i);
	    if (Character.isDigit(c))
		size *= c - '0';
	    else
		size++;
	}

	for (int i = N - 1; i >= 0; --i) {
	    char c = S.charAt(i);
	    K %= size;
	    if (K == 0 && Character.isLetter(c))
		return Character.toString(c);

	    if (Character.isDigit(c))
		size /= c - '0';
	    else
		size--;
	}

	throw null;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.decodeAtIndex("vk6u5xhq9v", 554);
    }
}
