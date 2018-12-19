package onlineElection;

import java.util.HashMap;
import java.util.Map;

//215ms solution, meet avg speed
public class TopVotedCandidate {

    private Node[] search;

    public TopVotedCandidate(int[] persons, int[] times) {
	search = new Node[times.length];
	Map<Integer, Integer> map = new HashMap<>();
	int max = 0;
	for (int i = 0; i < times.length; i++) {
	    int person = persons[i];
	    int time = times[i];
	    
	    Integer val = map.get(person);
	    if (val == null) {
		val = 1;
		map.put(person, 1);
	    } else {
		val++;
		map.put(person, val);
	    }

	    if (val >= max) {
		search[i] = new Node(time, person);
		max = val;
	    } else {
		search[i] = new Node(time, search[i - 1].person);
	    }
	}
    }

    public int q(int t) {
	// binary search
	int start = 0;
	int end = search.length - 1;
	while (start < end) {
	    if (search[end].time <= t) {
		return search[end].person;
	    }

	    if (end - start == 1) {
		return search[start].person;
	    } else {

		int mid = start + (end - start) / 2;

		if (search[mid].time == t) {
		    return search[mid].person;
		} else if (search[mid].time > t) {
		    end = mid;
		} else {
		    start = mid;
		}

	    }



	}

	return -1;
    }

    public static class Node {
	private int time;
	private int person;

	Node(int time, int person) {
	    this.time = time;
	    this.person = person;

	}

    }

    public static void main(String[] args) {
	/*
	 * ["TopVotedCandidate","q","q","q","q","q","q"]
	 * [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
	 */
	int[] persons = { 0, 1, 2, 2, 1 };
	int[] times = { 20, 28, 29, 54, 56 };

	TopVotedCandidate test = new TopVotedCandidate(persons, times);
	System.out.println(test.q(28));
	System.out.println(test.q(53));
	System.out.println(test.q(57));
	System.out.println(test.q(29));
	System.out.println(test.q(29));
	System.out.println(test.q(28));

    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times); int param_1 =
 * obj.q(t);
 */
