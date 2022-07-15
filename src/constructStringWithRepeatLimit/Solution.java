package constructStringWithRepeatLimit;

/*
Runtime: 26 ms, faster than 95.76% of Java online submissions for Construct String With Repeat Limit.
Memory Usage: 64.9 MB, less than 50.91% of Java online submissions for Construct String With Repeat Limit.
 */
public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] countArray =  new int[26];
        for (char c: s.toCharArray()) {
            countArray[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int x = 25;
        int y = 25;
        int repeat = 0;
        int lastIndex = -1;
        for (int i=25; i>=0; i--) {
            if (countArray[i]>0) {
                x=i;
                if (x == y) {
                    y--;
                }
                if (lastIndex != x) {
                    repeat=0;
                }
            }

            while ( countArray[x] > 0 ) {
                if(repeat == repeatLimit) {
                    if(y>=0 && countArray[y]==0) {
                        for(int j=x-1; j>=0 ; j--) {
                            if (countArray[j]>0){
                                y = j;
                                break;
                            }
                        }
                    }
                    if(y<0 || countArray[y]==0){
                        return sb.toString();
                    }
                    sb.append( (char)(y+'a'));
                    countArray[y]--;
                    repeat=0;
                    lastIndex = y;
                }else {
                    sb.append((char) (x + 'a'));
                    countArray[x]--;
                    repeat++;
                    lastIndex=x;
                }
            }


        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.repeatLimitedString("cczaaaaaazcc", 3);
    }
}
