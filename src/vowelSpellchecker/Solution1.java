package vowelSpellchecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    // group the word by length, still over time. 50/53
    public String[] spellchecker(String[] wordlist, String[] queries) {
	Map<Integer, List<String>> map = new HashMap<>();
	for(String word : wordlist) {
	    List<String> li = map.get(word.length());
	    if(li == null) {
		li = new ArrayList<>();
		map.put(word.length(), li);
	    }
	    
	    li.add(word);
	}
	String[] res = new String[queries.length];
	
	for (int i = 0; i < queries.length; i++) {
	    String q = queries[i];
	    int score = -1;
	    
	    List<String> words = map.get(q.length());
	    
	    if(words == null) {
		res[i] = "";
		continue;
	    }
	    
	    for (int j = 0; j < words.size(); j++) {
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

}
