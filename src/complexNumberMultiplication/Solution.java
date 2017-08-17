package complexNumberMultiplication;

public class Solution {
  // beat 50%
  public String complexNumberMultiply(String a, String b) {
    int[] A = ConvertToArray(a);
    int[] B = ConvertToArray(b);

    int[] result = new int[3];

    result[0] = A[0] * B[0];
    result[1] = A[0] * B[1] + A[1] * B[0];
    result[2] = A[1] * B[1];

    StringBuffer sb = new StringBuffer();
    sb.append(result[2] - result[0]).append("+").append(result[1]).append("i");
    return sb.toString();

  }

  private int[] ConvertToArray(String s) {
    String[] r = s.split("\\+");
    int[] result = new int[2];

    result[1] = Integer.valueOf(r[0]);
    String r1 = r[1].substring(0, r[1].length() - 1);
    result[0] = Integer.valueOf(r1);
    return result;
  }

}
