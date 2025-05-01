package mostPopularVideoCreator;

import java.util.*;
/*
59ms
Beats
35.88%
Analyze Complexity
Memory
127.43 MB
Beats
6.10%
 */
public class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, VideoNode> creatorTotalVideoMap = new HashMap<>();
        long maxVideoCnt = 0L;
        Set<String> resNames = new HashSet<>();
        for (int i=0; i<creators.length; i++) {
            VideoNode node = creatorTotalVideoMap.get(creators[i]);
            if (node == null) {
                node = new VideoNode(ids[i], views[i]);
                creatorTotalVideoMap.put(creators[i], node);
            }else{
                node.update(ids[i], views[i]);
            }

            if (node.total > maxVideoCnt) {
                maxVideoCnt = node.total;
                resNames.clear();
                resNames.add(creators[i]);
            }else if (node.total == maxVideoCnt) {
                resNames.add(creators[i]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String name : resNames) {
            List<String> item = new ArrayList<>();
            item.add(name);
            VideoNode node = creatorTotalVideoMap.get(name);
            String targetId = "";
            for (String id : node.videoIdAndCntMap.keySet()) {
                if (targetId.isEmpty()) {
                    targetId = id;
                }else if (node.videoIdAndCntMap.get(targetId)<node.videoIdAndCntMap.get(id)){
                    targetId = id;
                }else if (node.videoIdAndCntMap.get(targetId).equals(node.videoIdAndCntMap.get(id)) &&id.compareTo(targetId)<0) {
                    targetId = id;
                }
            }
            item.add(targetId);
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] creators = {"a","a"};
        String[] ids = {"a","cca"};
        int[] views = {1000000000,1000000000};
        solution.mostPopularCreator(creators, ids, views);
    }

    public static class VideoNode {
        private Map<String, Integer> videoIdAndCntMap = new HashMap<>();
        private long total=0L;

        VideoNode(String id, int viewCnt){
            videoIdAndCntMap.put(id, viewCnt);
            total = viewCnt;
        }
        void update(String id, int viewCnt){
            this.videoIdAndCntMap.put(id, viewCnt);
            this.total += viewCnt;
        }
    }
}
