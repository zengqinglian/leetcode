package findKthBitinNthBinaryString;
/*
Runtime: 1 ms, faster than 70.00% of Java online submissions for Find Kth Bit in Nth Binary String.
Memory Usage: 38.2 MB, less than 73.24% of Java online submissions for Find Kth Bit in Nth Binary String.
 */
public class Solution {
  int change = 0;
  public char findKthBit(int n, int k) {
    char[] base = {'0','1', '1','1'};
    if(k<=4) {
      return base[k-1];
    }
    int pow = (int)(Math.log(k) / Math.log(2));
    int shift = k-(int)Math.pow(2, pow);
    if(shift==0){
      return '1';
    }
    int idx = index(k);
    if(change % 2 == 1) {
      if(base[idx-1] =='1'){
        return '0';
      }
      return '1';
    }
    return base[idx-1];

  }

  private int index(int k) {
    int pow = (int)(Math.log(k) / Math.log(2));
    int shift = k-(int)Math.pow(2, pow);
    if(shift == 0) {
      return 4;
    }
    int newK = (int)Math.pow(2, pow) - shift;
    change++;
    if(newK <=4 ) {
      return newK;
    }
    return index(newK);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.findKthBit(5,24);
  }
}
