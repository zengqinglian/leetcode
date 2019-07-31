package oneTwoThreePattern;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    // someone's O(n) solution
    public boolean find132pattern(int[] nums) {
	if (nums == null || nums.length < 3) {
	    return false;
	}
	Deque<Integer> possibleRight = new ArrayDeque<>();
	int[] minLeft = new int[nums.length];
	int currentMin = Integer.MAX_VALUE;

	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] < currentMin) {
		currentMin = nums[i];
	    }
	    minLeft[i] = currentMin;
	}

	// Start looking for possible middle element from right most side
	for (int i = nums.length - 1; i >= 0; i--) {
	    // Skip bottom element
	    if (nums[i] <= minLeft[i]) {
		continue;
	    }
	    // Push nums[i] as a possible right for initial state,
	    // OR if the top element in the stack is not smaller than nums[i]
	    // as in this case no possible right for current nums[i]
	    // (there is no element in the stack that satisfy e < nums[i] && e > minLeft[i],
	    // otherwise it will be found before reaching to current nums[i])
	    else if (possibleRight.isEmpty() || possibleRight.peek() >= nums[i]) {
		possibleRight.push(nums[i]);
	    } else {
		// check each possible right for the current nums[i] that satisfied
		// possibleRight < nums[i]
		while (!possibleRight.isEmpty() && possibleRight.peek() < nums[i]) {
		    if (possibleRight.peek() > minLeft[i]) {
			return true;
		    } else {
			// remove this element from stack,
			// as it is impossible to have a future nums[i] that satisfied
			// e < nums[i] && e > minLeft[i]
			// because e is smaller than the current minLeft
			// and it is ensured that no future minLeft < current minLeft
			possibleRight.pop();
		    }
		}

		// No possible right found for current nums[i]
		// push nums[i] as a possible right candidate for future
		possibleRight.push(nums[i]);
	    }
	}

	return false;
    }
}
