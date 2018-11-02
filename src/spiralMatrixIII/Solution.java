package spiralMatrixIII;

import java.util.LinkedList;

public class Solution {
    // 18ms solution , meet avg speed
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
	int[][] result = new int[R * C][2];
	int[] start = { r0, c0 };
	result[0] = start;
	LinkedList<int[]> list = new LinkedList<>();
	int[] deltaR = {0,1,1,1,0,-1,-1,-1};
	int[] deltaC = {1,1,0,-1,-1,-1,0,1};
	
	for(int i=0; i<deltaR.length; i++) {
	    if(r0+deltaR[i]>=0 && r0+deltaR[i]<R  && c0+deltaC[i] >=0 && c0+deltaC[i]<C) {
		int[] node = {r0+deltaR[i], c0 + deltaC[i],deltaR[i], deltaC[i]};
		list.add(node);
	    }
	}

	int index = 1;

	while (!list.isEmpty()) {
	    int size = list.size();
	    for (int i = 0; i < size; i++) {
		int[] cur = list.removeFirst();
		int[] toR = { cur[0], cur[1] };
		result[index] = toR;
		index++;
		int newR = cur[0] + cur[2];
		int newC = cur[1] + cur[3];

		if (Math.abs(cur[2]) == Math.abs(cur[3])) {
		    if ((cur[2] == 1 && cur[3] == 1) || (cur[2] == -1 && cur[3] == -1)) {
			if (newC >= 0 && newC < C) {
			    int[] newNode = { cur[0], newC, 0, cur[3] };
			    list.add(newNode);
			}
			if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
			    int[] newNode = { newR, newC, cur[2], cur[3] };
			    list.add(newNode);
			}
			if (newR >= 0 && newR < R) {
			    int[] newNode = { newR, cur[1], cur[2], 0 };
			    list.add(newNode);
			}
		    }
		    if ((cur[2] == 1 && cur[3] == -1) || (cur[2] == -1 && cur[3] == 1)) {
			if (newR >= 0 && newR < R) {
			    int[] newNode = { newR, cur[1], cur[2], 0 };
			    list.add(newNode);
			}

			if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
			    int[] newNode = { newR, newC, cur[2], cur[3] };
			    list.add(newNode);
			}
			if (newC >= 0 && newC < C) {
			    int[] newNode = { cur[0], newC, 0, cur[3] };
			    if (cur[3] != 1) {
				list.add(newNode);
			    } else {
				list.addFirst(newNode);
			    }
			}
		    }

		} else {
		    if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
			int[] newNode = { newR, newC, cur[2], cur[3] };
			list.add(newNode);
		    }
		}
	    }
	    
	}

	return result;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.spiralMatrixIII(5, 6, 4, 0);
    }
}
