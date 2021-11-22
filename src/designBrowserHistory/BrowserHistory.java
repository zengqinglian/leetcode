package designBrowserHistory;

import java.util.ArrayList;
import java.util.List;
/*
Runtime: 85 ms, faster than 30.91% of Java online submissions for Design Browser History.
Memory Usage: 108.4 MB, less than 23.64% of Java online submissions for Design Browser History.
 */
public class BrowserHistory {
    List<String> list = new ArrayList<>();
    int currentIndex = -1;
    public BrowserHistory(String homepage) {
        list.add(homepage);
        currentIndex=0;
    }

    public void visit(String url) {
        if(currentIndex<list.size()-1) {
            list.subList(currentIndex+1, list.size()).clear();
        }
        list.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        currentIndex = currentIndex - steps;
        if(currentIndex<0){
            currentIndex=0;
        }
        return list.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = currentIndex+steps;
        if(currentIndex>=list.size()){
            currentIndex=list.size()-1;
        }
        return list.get(currentIndex);
    }


    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */
}
