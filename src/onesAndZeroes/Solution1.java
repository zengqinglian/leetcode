package onesAndZeroes;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // 210 ms soltuion , beat only 7%
    public int findMaxForm(String[] strs, int m, int n) {
	Map<Node, Integer> map = new HashMap<>();
	int max = 0;
	for(String str : strs) {
	    int cntZero=0,cntOne=0;
	    boolean good = true;
	    for (char c : str.toCharArray()) {
		if (c == '0') {
		    cntZero++;
		} else {
		    cntOne++;
		}
		if (cntZero > m || cntOne > n) {
		    good = false;
		    break;
		}
	    }
	    
	    if(good) {
		Map<Node, Integer> addedmap = new HashMap<>();
		for(Node node : map.keySet()) {
		    int newZeros = node.zeros + cntZero;
		    int newOnes = node.ones + cntOne;
		    int oldNum = map.get(node);
		    if (newZeros <= m && newOnes <= n) {
			Node newNode = new Node(newZeros, newOnes);
			Integer newNum = map.get(newNode);
			if (newNum == null) {
			    addedmap.put(newNode, oldNum + 1);
			} else {
			    addedmap.put(newNode, Math.max(newNum, oldNum + 1));
			}
			max = Math.max(max, oldNum + 1);
		    } else {
			max = Math.max(max, oldNum);
		    }
		}
		
		Node node = new Node(cntZero, cntOne);
		addedmap.putIfAbsent(node, 1);
		map.putAll(addedmap);
		max = Math.max(max, 1);
	    }
	}
	return max;
    }

    private static class Node {
	private int zeros;
	private int ones;

	Node(int zeros, int ones) {
	    this.ones = ones;
	    this.zeros = zeros;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ones;
	    result = prime * result + zeros;
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
	    Node other = (Node) obj;
	    if (ones != other.ones)
		return false;
	    if (zeros != other.zeros)
		return false;
	    return true;
	}

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	String[] strs = { "10", "0001", "111001", "1", "0" };
	s.findMaxForm(strs, 5, 3);
    }
}
