package distantBarcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    //8ms solution, beat 90%
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] valCnt = new int[10001];
        for(int bar : barcodes){
            valCnt[bar]++;
        }

        TreeMap<Integer, List<Integer>>  cntTreeMap = new TreeMap<>();
        for(int i=1; i<=10000; i++){
            if(valCnt[i]>0){
                List<Integer> li = cntTreeMap.get(valCnt[i]);
                if(li == null){
                    li = new ArrayList<>();
                    cntTreeMap.put(valCnt[i],li);
                }
                li.add(i);
            }
        }
        int index =0;
        for(int repeat : cntTreeMap.descendingKeySet()){
            for(int value : cntTreeMap.get(repeat)){
                for(int j=0; j<repeat; j++){
                    barcodes[index] = value;
                    if(index + 2 < barcodes.length){
                        index = index+2;
                    }else{
                        index=1;
                    }
                }
            }
        }
        return barcodes;
    }
}
