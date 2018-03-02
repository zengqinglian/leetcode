package simplifyPath;

import java.util.LinkedList;

public class Solution {
    // 9ms solution, beat 80%
    public String simplifyPath(String path) {
	String[] paths = path.split("/");
	StringBuilder sb = new StringBuilder();
	LinkedList<String> lst = new LinkedList<>();
	for(String str : paths) {
	    if (str.equals("..")) {
		if (lst.size() > 0) {
		    lst.removeLast();
		}
	    } else if (str.equals(".")) {
		continue;
	    } else if (!str.isEmpty()) {
		lst.add(str);
	    }
	}
	sb.append("/");
	while (!lst.isEmpty()) {
	    if(lst.size()>1)
		sb.append(lst.removeFirst()).append("/");
	    else
		sb.append(lst.removeFirst());
	}
	
	return sb.toString();
    }
}
