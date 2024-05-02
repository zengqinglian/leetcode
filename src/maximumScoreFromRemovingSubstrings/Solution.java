package maximumScoreFromRemovingSubstrings;

import java.util.Deque;
import java.util.LinkedList;
/*
62ms
Beats
87.10%
of users with Java
Memory 55.17 MB
Beats
9.68%
of users with Java
 */
public class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c =='a' || c=='b') {
                if (deque.isEmpty()) {
                    deque.add(c);
                }else{
                    if (x>=y) {
                        if(deque.peekLast() =='a' && c=='b') {
                            deque.removeLast();
                            res+=x;
                        }else{
                            deque.add(c);
                        }
                    }else{
                        if(deque.peekLast() =='b' && c=='a') {
                            deque.removeLast();
                            res+=y;
                        }else{
                            deque.add(c);
                        }
                    }
                }
            }else{
                deque.add(c);
            }
        }
        if (!deque.isEmpty()) {
            Deque<Character> deque2 = new LinkedList<>();
            while (!deque.isEmpty()) {
                char c = deque.removeFirst();
                if (c=='a' || c=='b') {
                    if (deque2.isEmpty()) {
                        deque2.add(c);
                    }else{
                        if (x>=y) {
                            if(deque2.peekLast() =='b' && c=='a') {
                                deque2.removeLast();
                                res+=y;
                            }else{
                                deque2.add(c);
                            }
                        }else{
                            if(deque2.peekLast() =='a' && c=='b') {
                                deque2.removeLast();
                                res+=x;
                            }else{
                                deque2.add(c);
                            }
                        }
                    }
                }else{
                    deque2.add(c);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumGain("aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha",1926,4320);
    }
}
