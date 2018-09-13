package keysandRooms;

import java.util.List;
import java.util.Stack;

public class Solution {
    // 8ms solution , meet avg
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	Stack<Integer> stack = new Stack<>();
	int[] checker = new int[rooms.size()];
	checker[0] =1;
	int visitedCnt = 1;
	
	for(int room:rooms.get(0)) {
	    if (checker[room] == 0) {
		stack.push(room);
	    }
	}

	while (!stack.isEmpty()) {
	    int room = stack.pop();
	    checker[room] = 1;
	    visitedCnt++;
	    for (int key : rooms.get(room)) {
		if (checker[key] == 0) {
		    stack.push(key);
		}
	    }
	    if(visitedCnt == rooms.size()) {
		return true;
	    }
	}

	return (visitedCnt == rooms.size());

    }
}
