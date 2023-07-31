package designTwitter;

import java.util.*;
/*
Runtime
9 ms
Beats
86.91%
Memory
40.9 MB
Beats
32.17%
 */
public class Twitter {

    private Map<Integer, Set<Integer>> followingMap = new HashMap<>();
    private List<Integer> tweetUserIdQueue = new ArrayList<>();
    private List<Integer>[] userTweetList = new List[501];


    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        tweetUserIdQueue.add(userId);
        List<Integer> list = userTweetList[userId];
        if (list == null) {
            list = new ArrayList<>();
            userTweetList[userId] = list;
        }
        list.add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> counterMap = new HashMap<>();
        int counter = 0;
        for(int i=tweetUserIdQueue.size()-1; i>=0 && counter<10; i--) {
            int tweetedUserId = tweetUserIdQueue.get(i);
            if (userId == tweetedUserId || ( followingMap.get(userId)!=null && followingMap.get(userId).contains(tweetedUserId) )) {
                Integer shift = counterMap.get(tweetedUserId);
                if (shift == null) {
                    counterMap.put(tweetedUserId,0);
                }
                res.add(userTweetList[tweetedUserId].get(userTweetList[tweetedUserId].size()-1-counterMap.get(tweetedUserId)));
                counterMap.put(tweetedUserId,counterMap.get(tweetedUserId)+1);
                counter++;
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followingSet = followingMap.computeIfAbsent(followerId, k -> new HashSet<>());
        followingSet.add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followingMap.get(followerId);
        if (set!=null) {
            set.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
