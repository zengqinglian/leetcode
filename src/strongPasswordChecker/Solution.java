package strongPasswordChecker;

public class Solution {
    public int strongPasswordChecker(String s) {
        if (s.length() < 6) {
            return 6 - s.length();
        }

        return 6 - s.length();

    }

    public static void main(String[] args) {
        String A = "Rahul Kumar";
        String b = "Rahul Kumar";
        String c = "Rahul Kumar";

        if (A == b) {
            System.out.println("true");
        }
    }
}
