package snapshotArray;

import java.util.HashMap;
import java.util.Map;

//750 ms solution , beat 5%
public class SnapshotArray {
    private Map<Integer, Value> map;
    private int snapcount = 0;

    public SnapshotArray(int length) {
	map = new HashMap<>(length);
    }

    public void set(int index, int val) {
	Value v = map.get(index);
	if (v == null) {
	    v = new Value(val);
	    map.put(index, v);
	}
	v.value = val;
    }

    public int snap() {
	for (Value v : map.values()) {
	    v.snapValues.put(snapcount, v.value);
	}
	return snapcount++;
    }

    public int get(int index, int snap_id) {
	Value v = map.get(index);
	if (v == null) {
	    return 0;
	}

	if (v.snapValues.get(snap_id) == null) {
	    return 0;
	}

	return v.snapValues.get(snap_id);
    }

    private static class Value {

	private int value;
	private Map<Integer, Integer> snapValues = new HashMap<>();

	Value(int value) {
	    this.value = value;
	}

    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
