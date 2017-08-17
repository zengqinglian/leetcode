package palindromicSubstrings;

public class Solution2 {
  // someone's faster solution
  public int countSubstrings(String s) {
    int sum = 0;
    // Loop across different middle points.
    for (int i = 0; i < s.length(); i++) {
      // Find all odd length palindrome with i as middle point.
      sum += findPalindromic(s, i, i);
      // Find all even length palindrome with i and i+1 as middle point.
      sum += findPalindromic(s, i, i + 1);
    }
    return sum;
  }

  // Expend from the current mid point to all of its low and high positions.
  private int findPalindromic(String s, int left, int right) {
    int count = 0;
    // Increase count if the substring is a validate palindrome.
    while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
      count++;
    return count;
  }
}
