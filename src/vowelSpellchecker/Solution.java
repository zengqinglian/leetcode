package vowelSpellchecker;

public class Solution {

    // Over time solution. failed at 50/53
    public String[] spellchecker(String[] wordlist, String[] queries) {
	String[] res = new String[queries.length];
	for (int i = 0; i < queries.length; i++) {
	    String q = queries[i];
	    int score = -1;
	    for (int j = 0; j < wordlist.length; j++) {
		String word = wordlist[j];
		if (word.length() != q.length()) {
		    continue;
		}

		if (word.equals(q)) {
		    res[i] = word;
		    score = 2;
		    break;
		} else if (score < 1 && word.equalsIgnoreCase(q)) {
		    res[i] = word;
		    score = 1;
		} else if (score < 0 && matchVowel(q, word)) {
		    res[i] = word;
		    score = 0;
		}
	    }
	    if (score < 0) {
		res[i] = "";
	    }
	}

	return res;

    }

    private boolean matchVowel(String q, String word) {
	if (q.length() != word.length()) {
	    return false;
	}

	for (int i = 0; i < q.length(); i++) {
	    char qc = q.charAt(i);
	    char wc = word.charAt(i);
	    if (isVowel(qc) && isVowel(wc)) {
		continue;
	    } else {
		if (!String.valueOf(qc).equalsIgnoreCase(String.valueOf(wc))) {
		    return false;
		}
	    }
	}

	return true;
    }

    private boolean isVowel(char qc) {
	return (qc == 'a' || qc == 'A' || qc == 'e' || qc == 'E' || qc == 'i' || qc == 'I' || qc == 'o' || qc == 'O'
		|| qc == 'u' || qc == 'U');

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] wordlist = { "KiTe", "kite", "hare", "Hare" };
	String[] queries = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" };
	s.spellchecker(wordlist, queries);
    }
}
