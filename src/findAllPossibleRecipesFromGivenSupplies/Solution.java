package findAllPossibleRecipesFromGivenSupplies;

import java.util.*;
/*
489ms
Beats
10.53%
Analyze Complexity
Memory
46.05 MB
Beats
96.18%

 */
public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        List<String> res = new ArrayList<>();
        boolean[] checked = new boolean[recipes.length];
        hasNewSupplies(recipes, ingredients, suppliesSet, res, checked);
        return res;
    }

    private void hasNewSupplies(String[] recipes, List<List<String>> ingredients, Set<String> suppliesSet, List<String> res, boolean[] checked) {
        int initialSupplies = suppliesSet.size();
        for (int i=0; i<recipes.length; i++) {
            if (checked[i]) {
                continue;
            }
            boolean canSupply = true;
            for (String s : ingredients.get(i)) {
                if (!suppliesSet.contains(s)) {
                    canSupply = false;
                    break;
                }
            }
            if (canSupply) {
                res.add(recipes[i]);
                checked[i] = true;
                suppliesSet.add(recipes[i]);
            }
        }
        if (initialSupplies != suppliesSet.size()) {
            hasNewSupplies(recipes, ingredients, suppliesSet, res, checked);
        }
    }

}
