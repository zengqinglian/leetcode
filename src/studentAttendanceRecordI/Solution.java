package studentAttendanceRecordI;

public class Solution {
    public boolean checkRecord(String s) {
        int totalA = 0;
        int contintusL =0;
        for(char c : s.toCharArray()){
            if(c=='A'){
                totalA++;
                if (totalA == 2) {
                    return false;
                }
                contintusL =0;
            }
            
            if(c=='L'){
                contintusL++;
                if (contintusL == 3) {
                    return false;
                }
            }
            
            if(c=='P'){
                contintusL =0;
            }
        }
        return true;
    }

}
