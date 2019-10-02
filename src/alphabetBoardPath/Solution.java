package alphabetBoardPath;

public class Solution {
    // 0ms , beat 100%
    public String alphabetBoardPath(String target) {
	int len = 5;
	int[] pos = { 0, 0 };
	StringBuilder sb = new StringBuilder();
	for (char c : target.toCharArray()) {
	    int[] newPos = getNewPosition(c, len);
	    int shiftX = newPos[0] - pos[0];
	    int shiftY = newPos[1] - pos[1];
	    if (shiftX > 0) {
		if (newPos[0] < len) {
		    for (int n = 0; n < shiftX; n++) {
			sb.append("D");
		    }
		} else {
		    for (int n = 0; n < shiftX - 1; n++) {
			sb.append("D");
		    }
		}
	    }else if (shiftX<0) {
		for (int n = 0; n < -shiftX; n++) {
		    sb.append("U");
		}
	    }
	    
	    if (shiftY > 0) {
		for (int n = 0; n < shiftY; n++) {
		    sb.append("R");
		}
	    }else if (shiftY<0) {
		for (int n = 0; n < -shiftY; n++) {
		    sb.append("L");
		}
	    }

	    if (newPos[0] == 5 && shiftX > 0) {
		sb.append("D");
	    }

	    sb.append("!");
	    pos = newPos;
		
	}
	
	return sb.toString();
    }

    private int[] getNewPosition(char c, int len) {
	int v = c - 'a';
	int x = v / len;
	int y = v % len;
	int[] res = { x, y };
	return res;
    }

    public static void main(String[] args) {
	Solution s= new Solution();
	s.alphabetBoardPath("zdz");
    }
}
