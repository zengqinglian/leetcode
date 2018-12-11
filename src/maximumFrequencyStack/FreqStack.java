package maximumFrequencyStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FreqStack {
    // 248ms solution , beat only 10%
    TreeMap<Integer, Set<Integer>> totalToNum = new TreeMap<>();
    Map<Integer, Integer> numToTotal = new HashMap<>();
    LinkedList<Integer> llist = new LinkedList<>();

    public FreqStack() {

    }

    public void push(int x) {
	Integer val = numToTotal.get(x);
	if (val == null || val == 0) {
	    numToTotal.put(x, 1);
	    Set<Integer> set = totalToNum.get(1);
	    if (set == null) {
		set = new HashSet<>();
	    }
	    set.add(x);
	    totalToNum.put(1, set);
	}else{
	    numToTotal.put(x, val + 1);
	    totalToNum.get(val).remove(x);
	    Set<Integer> set = totalToNum.get(val + 1);
	    if (set != null) {
		set.add(x);
	    } else {
		set = new HashSet<>();
		set.add(x);
		totalToNum.put(val + 1, set);
	    }
	}
	llist.add(x);
    }

    public int pop() {
	Entry<Integer, Set<Integer>> last = totalToNum.lastEntry();
	Set<Integer> set = last.getValue();
	if(set.size()==1) {
	    int val = set.iterator().next();
	    totalToNum.remove(last.getKey());
	    Set<Integer> newSet = totalToNum.get(last.getKey() - 1);
	    if (newSet != null) {
		newSet.add(val);
	    } else {
		newSet = new HashSet<>();
		newSet.add(val);
		totalToNum.put(last.getKey() - 1, newSet);
	    }
	    numToTotal.put(val, numToTotal.get(val) - 1);
	    llist.removeLastOccurrence(val);
	    return val;
	} else {
	    Iterator<Integer> ita = llist.descendingIterator();
	    int val = 0;
	    while (ita.hasNext()) {
		val = ita.next();
		if (set.contains(val)) {
		    break;
		}
	    }

	    set.remove(val);
	    Set<Integer> newSet = totalToNum.get(last.getKey() - 1);
	    if (newSet != null) {
		newSet.add(val);
	    } else {
		newSet = new HashSet<>();
		newSet.add(val);
		totalToNum.put(last.getKey() - 1, newSet);
	    }
	    numToTotal.put(val, numToTotal.get(val) - 1);
	    llist.removeLastOccurrence(val);
	    return val;
	}
    }

    public static void main(String[] args) {
	FreqStack s = new FreqStack();
	s.push(4);
	s.push(0);
	s.push(9);
	s.push(3);
	s.push(4);
	s.push(2);

	System.out.println(s.pop());
	s.push(6);
	System.out.println(s.pop());
	s.push(1);
	System.out.println(s.pop());
	s.push(1);
	System.out.println(s.pop());
	s.push(4);

	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.pop());

    }
}
/**
 * Your FreqStack object will be instantiated and called as such: FreqStack obj
 * = new FreqStack(); obj.push(x); int param_2 = obj.pop();
 */
