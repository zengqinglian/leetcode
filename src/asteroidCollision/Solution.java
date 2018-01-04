package asteroidCollision;

import java.util.Arrays;

// 23 ms solution beat 95%
public class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    if (asteroids.length < 2) {
      return asteroids;
    }

    int index = 1;
    int end = 0;
    while (index < asteroids.length) {
      if (end == -1) {
        asteroids[0] = asteroids[index];
        end = 0;
        index++;
        continue;
      } else {
        if (asteroids[end] > 0 && asteroids[index] < 0) {
          if (Math.abs(asteroids[end]) == Math.abs(asteroids[index])) {
            end--;
            index++;
          } else if (Math.abs(asteroids[end]) > Math.abs(asteroids[index])) {
            index++;
          } else {
            end--;
          }
        } else {
          end++;
          asteroids[end] = asteroids[index];
          index++;
        }

      }

    }

    return Arrays.copyOf(asteroids, end + 1);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] asteroids = {-1, -2, 1, 2, -2, -2};
    s.asteroidCollision(asteroids);
  }
}
