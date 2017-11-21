package diagonalTraverse;

public class Solution {
  // 20ms solution beat only 10%
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }

    int H = matrix.length;
    int L = matrix[0].length;
    int[] result = new int[H * L];

    Direction initD = Direction.DOWN;
    MoveToNext initM = MoveToNext.RIGHTMOVE;
    int[] curPos = {0, 0};

    result[0] = matrix[0][0];
    int index = 1;

    while (index < result.length) {

      int[] newPos = initM.newPos(curPos);
      if (0 <= newPos[0] && newPos[0] <= L - 1 && 0 <= newPos[1] && newPos[1] <= H - 1) {
        result[index] = matrix[newPos[1]][newPos[0]];
        index++;
        int[] p = initD.nextCoordinate(newPos);
        while (0 <= p[0] && p[0] <= L - 1 && 0 <= p[1] && p[1] <= H - 1) {
          result[index] = matrix[p[1]][p[0]];
          index++;
          newPos = p;
          p = initD.nextCoordinate(p);
        }
        curPos = newPos;
        initD = initD.getNext();
        initM = initM.getNext(curPos, L, H);
      } else {
        initM = initM.getNext(curPos, L, H);
        continue;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] matrix = { {2, 3, 4}, {5, 6, 7}};
    s.findDiagonalOrder(matrix);
  }

  public enum Direction {
    UP {
      public Direction getNext() {
        return DOWN;
      }

      public int[] nextCoordinate(int[] pos) {
        int[] res = new int[2];
        res[0] = pos[0] + 1; // X
        res[1] = pos[1] - 1; // Y
        return res;
      }
    },
    DOWN {
      public Direction getNext() {
        return UP;
      }

      public int[] nextCoordinate(int[] pos) {
        int[] res = new int[2];
        res[0] = pos[0] - 1; // X
        res[1] = pos[1] + 1; // Y
        return res;
      }
    };
    public abstract Direction getNext();

    public abstract int[] nextCoordinate(int[] pos);
  }

  public enum MoveToNext {
    RIGHTMOVE {

      @Override
      public int[] newPos(int[] pos) {
        int[] res = new int[2];
        res[0] = pos[0] + 1; // X
        res[1] = pos[1]; // Y
        return res;
      }
    },
    DOWNMOVE {

      @Override
      public int[] newPos(int[] pos) {
        int[] res = new int[2];
        res[0] = pos[0];
        res[1] = pos[1] + 1;
        return res;
      }

    };

    public abstract int[] newPos(int[] pos);

    public MoveToNext getNext(int[] pos, int L, int H) {
      if (pos[1] == 0 && pos[0] + 1 < L) {
        return RIGHTMOVE;
      } else if (pos[0] == 0 && pos[1] + 1 < H) {
        return DOWNMOVE;
      } else if (pos[1] == H - 1) {
        return RIGHTMOVE;
      } else if (pos[0] == L - 1) {
        return DOWNMOVE;
      }

      return null;

    }
  }
}
