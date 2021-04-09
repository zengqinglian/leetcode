package numberofStepstoReduceaNumberinBinaryRepresentationtoOne;

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number in Binary Representation to One.
Memory Usage: 36.7 MB, less than 92.77% of Java online submissions for Number of Steps to Reduce a Number in Binary Representation to One.
 */
public class Solution {
    public int numSteps(String s) {
        int step = 0;
        char[] charArr = s.toCharArray();
        for(int i=charArr.length-1; i>=1; i--){
            if(charArr[i]=='0'){
                step++;
            }else{
                boolean allOnes = true;
                for(int j=i-1; j>=0 ; j--) {
                    if(charArr[j]=='0'){
                        charArr[j]='1';
                        allOnes = false;
                        break;
                    }else{
                        charArr[j]='0';
                    }
                }
                if(allOnes){
                    step += (i + 2);
                    break;
                } else {
                    step += 2;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numSteps("10");
    }
}
