package groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // slow solution - use hash. beat 0%
    public List<List<String>> groupAnagrams(String[] strs) {
	Map<HashKey, List<String>> result = new HashMap<>();
	for (String str : strs) {
	    HashKey key = new HashKey(str);
	    if (result.containsKey(key)) {
		result.get(key).add(str);
	    } else {
		List<String> li = new ArrayList<>();
		li.add(str);
		result.put(key, li);
	    }
	}
	return new ArrayList<List<String>>(result.values());
    }

    private class HashKey {
	private String keyVal;
	private Map<Character, Integer> map = new HashMap<>();

	HashKey(String key) {
	    keyVal = key;

	    for (char c : this.keyVal.toCharArray()) {
		if (map.containsKey(c)) {
		    map.put(c, map.get(c) + 1);
		} else {
		    map.put(c, 1);
		}
	    }
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    for (char c : keyVal.toCharArray()) {
		result = result + prime * (c - 'a');
	    }
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    HashKey other = (HashKey) obj;

	    if (keyVal == null) {
		if (other.keyVal != null)
		    return false;
	    } else {
		if (this.keyVal.length() != other.keyVal.length()) {
		    return false;
		}
		if (this.map.keySet().size() != other.map.keySet().size()) {
		    return false;
		}
		for (char c : this.map.keySet()) {
		    if (this.map.get(c) != other.map.get(c)) {
			return false;
		    }
		}

	    }
	    return true;
	}
    }
}
