package rangeFrequencyQueries;
import java.util.TreeSet;
/*
time over limit
18/20
 */
class RangeFreqQuery {

  private TreeSet<Integer>[] treeSets = new TreeSet[10001];
  public RangeFreqQuery(int[] arr) {
    for(int i =0; i<arr.length; i++) {
      if (treeSets[arr[i]] == null) {
        treeSets[arr[i]] = new TreeSet<>();
      }
      treeSets[arr[i]].add(i);
    }
  }

  public int query(int left, int right, int value) {
    TreeSet<Integer> treeSet = treeSets[value];
    if(treeSet == null) {
      return 0;
    }
    if(treeSet.last() < left || treeSet.first() > right) {
      return 0;
    }
    if(treeSet.first() >= left && treeSet.last()<= right) {
      return treeSet.size();
    }
    return treeSet.subSet(left, true, right, true).size();
  }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
