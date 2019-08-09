package snapshotArray;

import java.util.TreeMap;

//someone's 110 ms solution , beat 50%
public class SnapshotArray1 {
    // This means an array of TreeMap, similar to Integer[]
    TreeMap<Integer, Integer>[] record;
    int snap_id = 0;

    public SnapshotArray1(int length) {
	record = new TreeMap[length]; // declare the length of the array
	for (int i = 0; i < length; i++) {
	    record[i] = new TreeMap<Integer, Integer>();
	    record[i].put(0, 0);
	}
    }

    public void set(int index, int val) {
	record[index].put(snap_id, val);
    }

    public int snap() {
	return snap_id++;
    }

    public int get(int index, int snap_id) {
	// floorEntry: returns a key-value mapping associated with the greatest key less
	// than or equal to the given key
	return record[index].floorEntry(snap_id).getValue();
    }
}
