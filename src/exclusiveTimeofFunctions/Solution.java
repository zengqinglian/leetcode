package exclusiveTimeofFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
Runtime: 13 ms, faster than 26.75% of Java online submissions for Exclusive Time of Functions.
Memory Usage: 39.4 MB, less than 90.40% of Java online submissions for Exclusive Time of Functions.
 */
public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Node> stack = new Stack<>();
        int[] res = new int[n];
        for(String log : logs) {
            String[] infos = log.split(":");
            int id = Integer.parseInt(infos[0]);
            int timeStamp = Integer.parseInt(infos[2]);
            if("start".equals(infos[1])) {
                if(stack.isEmpty()) {
                    Node newNode = new Node();
                    newNode.id = id;
                    int[] timeline = {timeStamp, -1};
                    newNode.timeLines.add(timeline);
                    stack.push(newNode);
                }else {
                    Node curNode = stack.peek();
                    curNode.timeLines.get(curNode.timeLines.size()-1)[1] = timeStamp -1;

                    Node newNode = new Node();
                    newNode.id = id;
                    int[] timeline = {timeStamp, -1};
                    newNode.timeLines.add(timeline);
                    stack.push(newNode);
                }
            }else {
                Node curNode = stack.pop();
                curNode.timeLines.get(curNode.timeLines.size()-1)[1] = timeStamp;
                updateRes (res, curNode);
                if(!stack.isEmpty()) {
                    Node newCurNode = stack.peek();
                    int[] newTimeLine = {timeStamp+1, -1};
                    newCurNode.timeLines.add(newTimeLine);
                }
            }
        }
        return res;
    }

    private void updateRes(int[] res, Node curNode) {
        for(int[] timeline: curNode.timeLines){
            res[curNode.id]+= (timeline[1] - timeline[0] + 1);
        }
    }

    private static class Node {
        private int id;
        List<int[]> timeLines = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] logs = {"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
        s.exclusiveTime(2, Arrays.asList(logs));
    }
}
