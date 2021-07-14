package minimumNumberofFrogsCroaking;
/*
Runtime: 8 ms, faster than 80.51% of Java online submissions for Minimum Number of Frogs Croaking.
Memory Usage: 39.2 MB, less than 92.66% of Java online submissions for Minimum Number of Frogs Croaking.
 */
public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if(croakOfFrogs.length() % 5 != 0){
            return -1;
        }
        int[] montior = new int[5];
        int cnt=0;
        int available = 0;
        for(char c : croakOfFrogs.toCharArray()){
            int pos = getPos(c);
            if(pos == -1){
                return -1;
            }
            if(pos == 0){
                if(available==0) {
                    montior[pos]++;
                    cnt++;
                }else{
                    montior[pos]++;
                    available--;
                }
            }else{
                if(montior[pos-1]>0){
                    montior[pos-1]--;
                    montior[pos]++;
                }else{
                    return -1;
                }
                if(pos == 4){
                    available++;
                }
            }
        }
        for(int i=0; i<3; i++){
            if(montior[i]!=0){
                return -1;
            }
        }
        return cnt;
    }

    private int getPos (char c){
        if(c=='c'){
            return 0;
        }
        if(c=='r'){
            return 1;
        }
        if(c=='o'){
            return 2;
        }
        if(c=='a'){
            return 3;
        }
        if(c=='k'){
            return 4;
        }
        return -1;
    }
}
