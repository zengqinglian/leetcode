package findAllPossibleRecipesFromGivenSupplies;

import java.util.*;
/*
Runtime
49 ms
Beats
69.74%
Analyze Complexity
Memory
46.89 MB
Beats
37.36%
 */
public class Solution1 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipesIngredientsCountMap = new HashMap<>();
        Map<String, List<String>> ingredientsRecipesMap = new HashMap<>();
        for(int i=0; i<recipes.length; i++) {
            List<String> ingredient = ingredients.get(i);
            String recipe = recipes[i];
            recipesIngredientsCountMap.put(recipe, ingredient.size());
            for(String ingredientName : ingredient) {
                List<String> recipeList = ingredientsRecipesMap.computeIfAbsent(ingredientName, k -> new ArrayList<>());
                recipeList.add(recipe);
            }
        }
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        for (String supplie : supplies) {
            List<String> r = ingredientsRecipesMap.get(supplie);
            if (r != null) {
                for (String recipe : r) {
                    int newVal = recipesIngredientsCountMap.get(recipe)-1;
                    if (newVal == 0) {
                        q.add(recipe);
                        res.add(recipe);
                    }
                    recipesIngredientsCountMap.put(recipe, newVal);
                }
            }
        }
        while (!q.isEmpty()) {
            String current = q.poll();
            List<String> r = ingredientsRecipesMap.get(current);
            if (r != null) {
                for (String recipe : r) {
                    int newVal = recipesIngredientsCountMap.get(recipe)-1;
                    if (newVal == 0) {
                        q.add(recipe);
                        res.add(recipe);
                    }
                    recipesIngredientsCountMap.put(recipe, newVal);
                }
            }
        }
        return res;
    }
}
