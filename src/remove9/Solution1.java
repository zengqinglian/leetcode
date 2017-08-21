package remove9;

public class Solution1 {
  // improved solution
  /*
   * This is a radix problem. Just change decimal to 9-based.
   * http://artofproblemsolving.com/wiki/index.php?title=Base_numbers
   */
  public int newInteger(int n) {
    return Integer.parseInt(Integer.toString(n, 9));
  }

}
