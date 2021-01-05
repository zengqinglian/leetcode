package tweetCountsPerFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

//94ms solution, beat 70%
public class TweetCounts {
  private Map<String, TreeMap<Integer, Integer>> map;

  public TweetCounts() {
    map = new HashMap<>();
  }

  public void recordTweet(String tweetName, int time) {
    TreeMap<Integer, Integer> treeMap = map.get(tweetName);
    if (treeMap == null){
      treeMap=new TreeMap<>();
      map.put(tweetName,treeMap);
    }
    Integer count = treeMap.get(time);
    if(count==null){
      treeMap.put(time, 1);
    }else{
      treeMap.put(time, count+1);
    }

  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    TreeMap<Integer, Integer> treeMap = map.get(tweetName);
    List<Integer> list = new ArrayList<>();
    int rangeSecs = 0;
    if(freq.equalsIgnoreCase("minute")){
      rangeSecs = 60;
    }else if(freq.equalsIgnoreCase("hour")){
      rangeSecs = 60 * 60;
    }else{
      rangeSecs = 60 * 60 * 24;
    }
    int rangeEnd = startTime + rangeSecs;
    int rangeStart = startTime;
    if(treeMap == null){
      while(rangeEnd < endTime+1) {
        list.add(0);
        rangeStart = rangeEnd;
        rangeEnd = rangeEnd + rangeSecs;
      }
      if(rangeStart <= endTime ) {
        list.add(0);
      }
      return list;
    }

    SortedMap<Integer, Integer> subMap = treeMap.subMap(startTime, endTime+1);
    if(subMap.isEmpty()){
      while(rangeEnd < endTime+1) {
        list.add(0);
        rangeStart = rangeEnd;
        rangeEnd = rangeEnd + rangeSecs;
      }
      if(rangeStart <= endTime ) {
        list.add(0);
      }
      return list;
    }
    int cnt = 0;
    for(int key : subMap.keySet()){
      while(key >= rangeEnd){
        list.add(cnt);
        cnt = 0;
        rangeStart = rangeEnd;
        rangeEnd = rangeEnd + rangeSecs;
      }
      if(key <= rangeEnd){
        cnt += subMap.get(key);
      }
    }
    if(rangeEnd < endTime +1) {
      while (rangeEnd < endTime+1) {
        list.add(cnt);
        cnt=0;
        rangeStart = rangeEnd;
        rangeEnd = rangeEnd + rangeSecs;
      }
      if(rangeStart <= endTime ) {
        list.add(0);
      }
    }else{
      list.add(cnt);
    }
    return list;
  }

  /**
   * Your TweetCounts object will be instantiated and called as such:
   * TweetCounts obj = new TweetCounts();
   * obj.recordTweet(tweetName,time);
   * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
   */
  public static void main(String[] args) {
    TweetCounts tweetCounts = new TweetCounts();
    tweetCounts.recordTweet("tweet3",0);
    tweetCounts.recordTweet("tweet3",60);
    tweetCounts.recordTweet("tweet3",10);
    tweetCounts.getTweetCountsPerFrequency("minute","tweet3",0,59);
    tweetCounts.getTweetCountsPerFrequency("minute","tweet3",0,60);
    tweetCounts.recordTweet("tweet3",120);
    tweetCounts.getTweetCountsPerFrequency("hour","tweet3",0,210);
  }
}
