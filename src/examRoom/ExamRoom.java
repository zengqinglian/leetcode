package examRoom;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//Solution with set and map, no need loop all the gap every time
public class ExamRoom {

    TreeSet<int[]> intervals;
    Map<Integer, int[]> seatToLeft;
    Map<Integer, int[]> seatToRight;
    int N;

    private static int getDis(int[] interval, int N) {
	if (interval[0] == -1 || interval[1] == N)
	    return interval[1] - interval[0] - 1;
	else
	    return (interval[1] - interval[0]) / 2;
    }

    public ExamRoom(int N) {
	intervals = new TreeSet<>((a, b) -> {
	    int disA = getDis(a, N);
	    int disB = getDis(b, N);
	    if (disA == disB)
		return Integer.compare(a[0], b[0]);
	    else
		return Integer.compare(disB, disA);
	});
	intervals.add(new int[] { -1, N });
	seatToLeft = new HashMap<>();
	seatToRight = new HashMap<>();
	this.N = N;
    }

    public int seat() {
	int choose;

	int[] largest = intervals.pollFirst();

	// System.out.println(Arrays.toString(largest));
	if (largest[0] == -1)
	    choose = 0;
	else if (largest[1] == N)
	    choose = N - 1;
	else
	    choose = largest[0] + (largest[1] - largest[0]) / 2;

	int[] left = new int[] { largest[0], choose };
	int[] right = new int[] { choose, largest[1] };

	intervals.add(left);
	intervals.add(right);

	seatToLeft.put(choose, left);
	seatToRight.put(choose, right);

	seatToLeft.put(largest[1], right);
	seatToRight.put(largest[0], left);

	// System.out.println(choose);
	return choose;
    }

    public void leave(int p) {
	// System.out.println("leave:" + p);
	int[] left = seatToLeft.get(p);
	// System.out.println("left:" + Arrays.toString(left));
	int[] right = seatToRight.get(p);
	// System.out.println("right:" + Arrays.toString(right));
	intervals.remove(left);
	intervals.remove(right);
	int[] merged = new int[] { left[0], right[1] };
	intervals.add(merged);
	seatToRight.put(left[0], merged);
	seatToLeft.put(right[1], merged);

    }

    public static void main(String[] args) {
	ExamRoom er = new ExamRoom(10);
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());
	System.out.println(er.seat());

    }
}

/**
 * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
 * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
 */
