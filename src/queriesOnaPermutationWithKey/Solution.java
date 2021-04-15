package queriesOnaPermutationWithKey;

/*
Runtime: 7 ms, faster than 78.48% of Java online submissions for Queries on a Permutation With Key.
Memory Usage: 39 MB, less than 71.94% of Java online submissions for Queries on a Permutation With Key.
 */
public class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] indexToVal = new int[m];
        int[] valToIndex = new int[m+1];
        int[] res = new int[queries.length];
        for(int i=1; i<=m; i++){
            indexToVal[i-1] = i;
            valToIndex[i] = i-1;
        }
        for(int x=0; x<queries.length; x++){
            int oldIndexForValueQ = valToIndex[queries[x]];
            res[x] = oldIndexForValueQ;
            if(oldIndexForValueQ == 0){
                continue;
            }
            int oldValueAtIndex = indexToVal[oldIndexForValueQ];
            valToIndex[oldValueAtIndex] = 0;
            for(int i=oldIndexForValueQ; i>=1; i--){
                indexToVal[i] = indexToVal[i-1];
                valToIndex[indexToVal[i-1]]++;
            }
            indexToVal[0] = oldValueAtIndex;
        }
        return res;
    }
}
