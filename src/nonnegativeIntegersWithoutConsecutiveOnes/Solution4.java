package nonnegativeIntegersWithoutConsecutiveOnes;

public class Solution4 {
  public int findIntegers(int num) {
    // one:all bit before cur is less than num and no continues 1 and cur
    // bit is at one;
    // zero:all bit before cur is less than num and no continues 1 and cur
    // bit is at zero;

    /*
     * compress to 4 possible result for each bit:
     * 
     * all bit before cur is less than num and no continues 1 and cur bit is at one. all bit before
     * cur is less than num and no continues 1 and cur bit is at zero. cur and prev bit is equal to
     * num. larger than num or has contiunes '1'. then run through the tree.
     */
    int one = 0, zero = 0, temp;
    boolean isNum = true;
    for (int i = 31; i >= 0; i--) {
      temp = zero;
      zero += one;
      one = temp;
      if (isNum && ((num >> i) & 1) == 1) {
        zero += 1;
      }
      if (((num >> i) & 1) == 1 && ((num >> i + 1) & 1) == 1) {
        isNum = false;
      }

    }
    return one + zero + (isNum ? 1 : 0);
  }
}
