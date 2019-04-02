package timeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    // 285 ms solution , meet avg speed.
    /** Initialize your data structure here. */
    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
	TreeMap<Integer, String> tmap = map.get(key);
	if (tmap == null) {
	    tmap = new TreeMap<>();
	    map.put(key, tmap);
	}
	tmap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
	TreeMap<Integer, String> tmap = map.get(key);
	if (tmap == null) {
	    return "";
	}

	if (tmap.floorEntry(timestamp) != null) {
	    return tmap.floorEntry(timestamp).getValue();
	} else {
	    return "";
	}
    }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
