package getWatchedVideosbyYourFriends;

import java.util.*;

public class Solution {
    //25ms meet avg speed
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer>[] set = new Set[watchedVideos.size()];
        for(int i=0; i<friends.length; i++){
            set[i] = new HashSet<>();
            for(int v : friends[i]){
                set[i].add(v);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int cnt = 0;
        boolean[] marker = new boolean[watchedVideos.size()];
        marker[id] = true;
        while(cnt < level) {
            int size = q.size();
            for(int x=0; x<size; x++){
                int v = q.poll();
                for(int c : set[v]){
                    if(!marker[c]){
                        q.add(c);
                        marker[c]=true;
                    }
                }
            }
            cnt++;
        }
        Map<String, Node> map = new HashMap<>();
        while(!q.isEmpty()){
            int idx = q.poll();
            for(String video:watchedVideos.get(idx)){
                Node node = map.get(video);
                if(node == null){
                    node = new Node(video, 1);
                    map.put(video, node);
                }else {
                    node.cnt = node.cnt + 1;
                }
            }
        }
        List<Node> resNode = new ArrayList<>( map.values());
        Collections.sort(resNode, (a,b) ->{
            int compare = Integer.compare(a.cnt, b.cnt);
            if(compare == 0){
                return a.name.compareTo(b.name);
            }
            return compare;
        });
        List<String> res = new ArrayList<>();
        for(Node node : resNode){
            res.add(node.name);
        }

        return res;
    }

    private static class Node {
        private String name;
        private int cnt;
        Node(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> watchedVideos = new ArrayList<>();
        String[][] videoArr = {{"A","B"},{"C"},{"B","C"},{"D"}};
        for(String[] video : videoArr){
            watchedVideos.add(Arrays.asList(video));
        }
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        s.watchedVideosByFriends(watchedVideos, friends, 0,1);
    }
}
