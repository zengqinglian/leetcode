package cutOffTreesforGolfEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  // first soution - sort by value and then find min distance in order, add
  // them together
  // beat 50%
  public int cutOffTree(List<List<Integer>> forest) {
    PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

      @Override
      public int compare(Node o1, Node o2) {

        return o1.val - o2.val;
      }
    });

    for (int i = 0; i < forest.size(); i++) {
      for (int j = 0; j < forest.get(0).size(); j++) {
        if (forest.get(i).get(j) > 1) {
          Node newNode = new Node(i, j, forest.get(i).get(j));
          queue.add(newNode);
        }
      }
    }

    Node initNode = new Node(0, 0, forest.get(0).get(0));
    int steps = 0;

    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      if (cur.x == initNode.x && cur.y == initNode.y) {
        continue;
      } else {
        int minStep = getDistance(initNode, cur, forest);
        if (minStep < 0) {
          return -1;
        } else {
          steps += minStep;
        }
      }
      initNode = cur;
    }
    return steps;
  }

  // bfs cal min step
  private int getDistance(Node initNode, Node cur, List<List<Integer>> forest) {
    int l = forest.size();
    int h = forest.get(0).size();
    boolean[][] visited = new boolean[l][h];
    visited[initNode.x][initNode.y] = true;
    Queue<int[]> queue = new LinkedList<>();
    int[] startPoint = {initNode.x, initNode.y, 0};
    queue.add(startPoint);

    int[] moveX = {-1, 1, 0, 0};
    int[] moveY = {0, 0, -1, 1};
    while (!queue.isEmpty()) {
      int[] p = queue.poll();
      for (int i = 0; i <= 3; i++) {
        int newX = p[0] + moveX[i];
        int newY = p[1] + moveY[i];

        if (newX == cur.x && newY == cur.y) {
          return p[2] + 1;
        }

        if (newX >= 0 && newX <= l - 1 && newY >= 0 && newY <= h - 1 && !visited[newX][newY]
            && forest.get(newX).get(newY) > 0) {
          int[] newP = {newX, newY, p[2] + 1};
          queue.add(newP);
          visited[newX][newY] = true;
        }
      }
    }
    return -1;
  }

  private static class Node {
    private int x;
    private int y;
    private int val;

    public Node(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> li1 = new ArrayList<>();
    li1.add(16);
    li1.add(2);
    li1.add(3);

    List<Integer> li2 = new ArrayList<>();
    li2.add(9);
    li2.add(10);
    li2.add(11);

    List<Integer> li3 = new ArrayList<>();
    li3.add(7);
    li3.add(6);
    li3.add(5);

    List<List<Integer>> list = new ArrayList<>();
    list.add(li1);
    list.add(li2);
    list.add(li3);

    s.cutOffTree(list);
  }
}
