package smallestNumberinInfiniteSet;

import java.util.TreeSet;
/*
36ms solution, beat 36%
 */
public class SmallestInfiniteSet {
    private TreeSet<Integer> t = new TreeSet<>();

    public SmallestInfiniteSet() {
        for (int i=1; i<=1000; i++) {
            t.add(i);
        }
    }

    public int popSmallest() {
        return t.pollFirst();
    }

    public void addBack(int num) {
        t.add(num);
    }
}
