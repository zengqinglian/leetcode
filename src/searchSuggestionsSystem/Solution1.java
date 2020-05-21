package searchSuggestionsSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    //someone's another approach. sort products and compare searchword. beat 100%
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            ans.add(new ArrayList<>());
        }
        List<String> temp = null;
        Arrays.sort(products);
        for (int i = 0; i < products.length; ++i) {
            int commonPrefix = match(products[i], searchWord);
            for (int j = commonPrefix - 1; j >= 0; --j) {
                temp = ans.get(j);
                if (temp.size() == 3) {
                    break;
                }
                temp.add(products[i]);
            }
        }
        return ans;
    }

    private int match(String one, String two) {
        int i = 0;
        for (i = 0; i < one.length() && i < two.length(); ++i) {
            if (one.charAt(i) != two.charAt(i))
                return i;
        }
        return i;
    }
}
