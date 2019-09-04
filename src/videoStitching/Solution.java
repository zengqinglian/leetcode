package videoStitching;

public class Solution {
    // 0ms solution , beat 100%
    public int videoStitching(int[][] clips, int T) {

	int[] group = new int[101];
	group[0] = -1;
	for (int[] clip : clips) {
	    group[clip[0]] = Math.max(group[clip[0]], clip[1]);
	}
	
	if(group[0]==-1) {
	    return -1;
	}

	int cnt = 1;
	int e = group[0];
	int s = 0;
	while (e < T) {
	    int max = -1;
	    for (int i = s; i <= e; i++) {
		max = Math.max(max, group[i]);
	    }
	    if (max <= e) {
		return -1;
	    } else {
		s = e;
		e = max;
		cnt++;
	    }
	}
	return cnt;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] clips = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
	s.videoStitching(clips, 10);
    }
}
