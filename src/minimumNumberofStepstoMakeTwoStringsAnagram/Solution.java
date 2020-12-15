package minimumNumberofStepstoMakeTwoStringsAnagram;

public class Solution {
  //13ms solution , meet avg 50%
  public int minSteps(String s, String t) {
    int[] S = new int[26];
    int[] T = new int[26];
    for(int i=0; i<s.length(); i++){
      S[s.charAt(i)-'a']++;
      T[t.charAt(i)-'a']++;
    }
    int step = 0;
    for(int i=0; i<26; i++){
      int diff = S[i]-T[i];
      if(diff>0){
        step+=diff;
      }
    }
    return step;
  }
}
