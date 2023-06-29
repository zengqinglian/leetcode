package evaluateReversePolishNotation;
/*
Someone's recursive solution

1 ms , beat 100%
 */
public class Solution1 {
    String token [];
    int i;
    public int evalRPN(String[] tokens) {
        token = tokens;
        i = tokens.length - 1;
        return solve();
    }
    public int solve() {
        String s = token[i--];
        switch(s) {
            case "+" : return solve() + solve();
            case "*" : return solve() * solve();
            case "-" : int x = solve(); int y = solve();
                return y - x;
            case "/" : int p = solve(); int q = solve();
                return q / p;
            default: return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String[] tokens = {"4","-2","/","2","-3","-","-"};
        s.evalRPN(tokens);
    }
}
