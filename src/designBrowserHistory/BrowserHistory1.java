package designBrowserHistory;

import java.util.ArrayList;
import java.util.List;
/*
Runtime: 46 ms, faster than 83.51% of Java online submissions for Design Browser History.
Memory Usage: 47.6 MB, less than 52.72% of Java online submissions for Design Browser History.
 */
public class BrowserHistory1 {
    List<String> list = new ArrayList<>();
    int currentIndex = -1;
    int size = 0;
    public BrowserHistory1(String homepage) {
        list.add(homepage);
        currentIndex=0;
        size=1;
    }

    public void visit(String url) {
        currentIndex++;
        size=currentIndex+1;
        if(currentIndex==list.size()){
            list.add(url);
        }else {
            list.set(currentIndex, url);
        }
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
        if(currentIndex>=size){
            currentIndex=size-1;
        }
        return list.get(currentIndex);
    }
}
