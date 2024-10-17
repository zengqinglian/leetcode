package splitArrayIntoFibonacciSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Runtime
3ms
Beats 60.53%
Analyze Complexity
Memory
41.93 MB
Beats
78.95%

 */
public class Solution1 {
    private List<Integer> res = new ArrayList<>();
    private long MAX_INT = Integer.MAX_VALUE;
    public List<Integer> splitIntoFibonacci(String num) {
        for (int i = 0; i < Math.min(10, num.length()); i++) {
            String sub1 = num.substring(0, i+1);
            long sub1Val = Long.parseLong(sub1);
            if (sub1Val >= MAX_INT) {
                return Collections.emptyList();
            }
            res.add(Integer.parseInt(sub1));
            for (int j=i+1; j<Math.min(i+1+10, num.length()); j++) {
                String sub2 = num.substring(i+1, j+1);
                long sub2Val = Long.parseLong(sub2);
                if (sub2Val>= MAX_INT) {
                    break;
                }
                if (sub2.charAt(0)=='0' && sub2.length()>1) {
                    break;
                }
                res.add(Integer.parseInt(sub2));
                if (helper(num, j+1, Integer.parseInt(sub1), Integer.parseInt(sub2))) {
                    return res;
                }
                res.remove(res.size()-1);
            }
            res.remove(res.size()-1);
            if (num.charAt(0)=='0') {
                return res;
            }
        }
        return res;
    }

    private boolean helper(String num, int index, int p1, int p2) {
        if (((long)p1+(long)p2) != (long)(p1+p2)) {
            return false;
        }
        String total= String.valueOf(p1+p2);
        if (total.length() > num.length()-index) {
            return false;
        }else if (total.length() == num.length() - index) {
            String targetString = num.substring(index);
            if( total.equals(targetString) ) {
                if (targetString.length()>1 && num.charAt(index)=='0') {
                    return false;
                }else {
                    res.add(p1 + p2);
                    return true;
                }
            }else{
                return false;
            }
        }else{
            String targetString = num.substring(index, index+total.length());
            if (total.equals(targetString)) {
                if (targetString.length()>1 && num.charAt(index)=='0') {
                    return false;
                }else {
                    res.add(p1 + p2);
                    boolean newRes = helper(num, index + total.length(), p2, p1 + p2);
                    if (newRes) {
                        return true;
                    } else {
                        res.remove(res.size() - 1);
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.splitIntoFibonacci("121474836462147483647");
    }
}
