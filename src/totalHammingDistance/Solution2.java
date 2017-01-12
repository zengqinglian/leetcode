package totalHammingDistance;

public class Solution2 {
    // cache all result - over memory limit
    public int totalHammingDistance(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int[] cache = new int[1000000001];
        cache[0]=0;
        cache[1] = 1;
        int[] initRowNums = { 1 };
        createCache(initRowNums, cache, 2);

        int total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                total += hammingDistance(nums[i], nums[j], cache);
            }
        }
        return total;
    }
    
    private int hammingDistance(int i1, int i2, int[] cache) {
        int bitSum = i1 ^ i2;

        return cache[bitSum];
    }

    private void createCache(int[] rowNums, int[] cache, int counter){
        int[] newRowNums = new int[2*rowNums.length];
        int newIndex=0;
        if(counter+(2*rowNums.length)<=1000000000){
            for(int i : rowNums){
                cache[counter] = i;
                cache[counter + rowNums.length] = i + 1;
                counter++;
                
                newRowNums[newIndex] = i;
                newRowNums[newIndex + rowNums.length]=i+1;

                newIndex++;
            }
            
        } else {
            for (int i : rowNums) {
                if(counter<=1000000000){
                    cache[counter] = i;
                    counter++;
                }
                if (counter + rowNums.length <= 1000000000) {
                    cache[counter + rowNums.length] = i + 1;
                    counter++;
                }
                
                newRowNums[newIndex] = i;
                newRowNums[newIndex + rowNums.length]=i+1;
                newIndex++;
            }
        }
        if(counter<=1000000000){
            createCache(newRowNums, cache, counter);
        }
    }
}
