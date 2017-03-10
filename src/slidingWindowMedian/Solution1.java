package slidingWindowMedian;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Double> list = new ArrayList<Double>();

    // Someone's quicker solution - sorted insert to a list size of K
    public double[] medianSlidingWindow(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        double[] ret = new double[nums.length - k + 1];
        ret[0] = getmean();
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
            remove(nums[i - k]);
            ret[i - k + 1] = getmean();
        }
        return ret;
    }

    public double getmean() {
        int size = list.size();
        if (size % 2 == 1)
            return list.get(size / 2);
        else
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
    }

    public void remove(int i) {
        list.remove(find(i));
    }

    public void add(int i) {
        list.add(find(i), (double) i);
    }

    public int find(int i) {
        int st = 0, ed = list.size();
        while (st < ed) {
            int mid = st + (ed - st) / 2;
            if (list.get(mid) > i) {
                ed = mid;
            } else if (list.get(mid) == i) {
                return mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}
