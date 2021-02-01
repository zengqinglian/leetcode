package rankTeamsbyVotes;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    //6ms solution ,beat 70%
    public String rankTeams(String[] votes) {
        int[][] ranks = new int[26][votes[0].length()];
        Character[] allChars = new Character[votes[0].length()];
        for(String str : votes){
            for(int i= 0; i<str.length(); i++){
                char c = str.charAt(i);
                ranks[c-'A'][i]++;
            }
        }
        for(int i= 0; i<votes[0].length(); i++){
            char c = votes[0].charAt(i);
            allChars[i] = c;
        }

        Arrays.sort(allChars, (a,b) -> {
            int[] rankA = ranks[a-'A'];
            int[] rankB = ranks[b-'A'];
            for(int x = 0; x<allChars.length; x++){
                if(rankB[x]==rankA[x]){
                    continue;
                }else{
                    return Integer.compare(rankB[x], rankA[x]);
                }
            }
            return Character.compare(a,b);
        });

        return Arrays.stream(allChars).map(String::valueOf).collect(Collectors.joining());

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        s.rankTeams(votes);
    }
}
