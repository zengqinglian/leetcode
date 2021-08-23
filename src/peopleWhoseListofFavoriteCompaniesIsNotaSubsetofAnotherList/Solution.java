package peopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Runtime: 148 ms, faster than 73.97% of Java online submissions for People Whose List of Favorite Companies Is Not a Subset of Another List.
Memory Usage: 65.4 MB, less than 7.53% of Java online submissions for People Whose List of Favorite Companies Is Not a Subset of Another List.
 */
public class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> indexSort = IntStream.range(0, favoriteCompanies.size()).boxed()
                .sorted((a,b)->Integer.compare(favoriteCompanies.get(b).size(), favoriteCompanies.get(a).size()))
                .collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        Map<String, Set<Integer>> map = new HashMap<>();
        for(int index : indexSort){
            Set<Integer> compare = null;
            boolean added = false;
            for(String str : favoriteCompanies.get(index)){
                Set<Integer> set = map.get(str);
                if(set == null){
                   set = new HashSet<>();
                   map.put(str, set);
                   set.add(index);
                   if(!added) {
                       res.add(index);
                       added = true;
                   }
                }else{
                    if(compare == null){
                        compare = new HashSet<>(set);
                    }else{
                        compare.retainAll(set);
                    }
                    set.add(index);
                }
            }
            if(!added){
                if(compare == null || compare.size() == 0)
                    res.add(index);
            }


        }
        Collections.sort(res);
        return res;
    }


}
