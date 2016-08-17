package miniParser;

import java.util.Stack;

public class Solution {
    // 35ms solution
    public NestedInteger deserialize(String s) {
        return create(s, null);
    }

    private NestedInteger create(String s, NestedInteger parent) {
        if (s.isEmpty()) {
            return parent;
        }
        if (s.charAt(0) == '[') {
            NestedInteger ni = new NestedInteger();
            // find match ]
            int endIndex = getEndIndex(s);
            if (parent == null) {
                if (!s.isEmpty()) {
                    if (endIndex == s.length() - 1) {
                        create(s.substring(1, endIndex), ni);
                    }
                }
                return ni;
            } else {
                parent.add(ni);
                if (!s.isEmpty()) {
                    if (endIndex == s.length() - 1) {
                        create(s.substring(1, endIndex), ni);
                    } else {
                        create(s.substring(1, endIndex), ni);
                        if (s.charAt(endIndex + 1) == ',') {
                            create(s.substring(endIndex + 2), parent);
                        } else {
                            create(s.substring(endIndex + 1), parent);
                        }
                    }
                }
                return parent;
            }
        } else {
            if (s.isEmpty()) {
                throw new RuntimeException();
            } else {
                int comma = s.indexOf(',');
                NestedInteger ni = new NestedInteger();
                if(comma==-1){
                    ni.setInteger(Integer.valueOf(s));
                    if (parent == null) {
                        return ni;
                    } else {
                        parent.add(ni);
                        return parent;
                    }
                }else{
                    ni.setInteger(Integer.valueOf(s.substring(0, comma)));
                    parent.add(ni);
                    create(s.substring(comma+1),parent);
                    return parent;
                }
            }
        }
    }

    private int getEndIndex(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else if (c == ']') {
                stack.pop();
                if (stack.isEmpty()) {
                    return index;
                }
            }
            index++;
        }
        return index;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.deserialize("[789,[123],[[]]]");
    }
}
