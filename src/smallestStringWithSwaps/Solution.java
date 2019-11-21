package smallestStringWithSwaps;

import java.util.*;

public class Solution {
    //490ms solution , beat 5%
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() ==0){
            return s;
        }
        List<Integer>[] groups = new List[s.length()];
        for(List<Integer> li : pairs){
            int p1= li.get(0);
            int p2 = li.get(1);
            if(groups[p1]==null){
                groups[p1] = new ArrayList();
            }
            groups[p1].add(p2);
            if(groups[p2] == null){
                groups[p2] = new ArrayList();
            }
            groups[p2].add(p1);
        }

        boolean[] visited = new boolean[s.length()];
        char[] tempRes = new char[s.length()];
        char[] res = new char[s.length()];

        for(int i= 0; i<s.length(); i++){
            int resIndex = 0;
            Queue<Integer> q = new LinkedList<>();
            if(!visited[i]){
                if(groups[i]==null){
                    res[i]= s.charAt(i);
                    visited[i] = true;
                    continue;
                }else {
                    tempRes[resIndex++] = s.charAt(i);
                    visited[i] = true;
                    q.add(i);
                }

            }
            if(q.isEmpty()){
                continue;
            }
            while(!q.isEmpty()){
                int idx = q.poll();
                for(int v : groups[idx]){
                    if(!visited[v]){
                        tempRes[resIndex++]=s.charAt(v);
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
            Arrays.sort(tempRes, 0, resIndex);
            for(int idx=0, index=0; idx<resIndex && index<s.length(); ){
                if(visited[index]){
                   if(res[index]<'a' || res[index]>'z'){
                       res[index++] = tempRes[idx++];
                   }else{
                       index++;
                   }
                }else{
                    index++;
                }
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> p1 = createPairs(0,3);
        List<Integer> p2 = createPairs(1,2);
        pairs.add(p1);
        pairs.add(p2);
        s.smallestStringWithSwaps("dcab", pairs);
    }

    private static List<Integer> createPairs(int a, int b){
        List<Integer> p = new ArrayList<>();
        p.add(a);
        p.add(b);
        return p;
    }
}
