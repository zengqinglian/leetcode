package restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 6ms solution - beat 21%
    public List<String> restoreIpAddresses(String s) {
	List<String> result = new ArrayList<>();
	if (s.length() < 4 || s.length() > 12) {
	    return new ArrayList<String>(result);
	}
	List<String> temp = new ArrayList<String>();
	temp.add(String.valueOf(s.charAt(0)));
	generateIp(1, s, temp, result);
	return result;
    }

    private void generateIp(int i, String s, List<String> temp, List<String> result) {

	if (i == s.length()) {
	    if (temp.size() != 4) {
		return;
	    }
	    StringBuilder sb = new StringBuilder();
	    for (String str : temp) {
		sb.append(str).append(".");
	    }
	    String ip = sb.toString();
	    result.add(sb.toString().substring(0, ip.length() - 1));
	    return;
	}
	int cur = s.charAt(i) - '0';
	String strCur = String.valueOf(cur);
	if (temp.size() < 4) {
	    String last = temp.get(temp.size() - 1);
	    int lastInt = Integer.valueOf(last);
	    if (last.length() == 3 || last.equals("0")) {
		temp.add(strCur);
		generateIp(i + 1, s, temp, result);
		temp.remove(temp.size() - 1);
	    } else {
		if (lastInt * 10 + cur > 255) {
		    temp.add(strCur);
		    generateIp(i + 1, s, temp, result);
		    temp.remove(temp.size() - 1);
		} else {
		    temp.add(strCur);
		    generateIp(i + 1, s, temp, result);
		    temp.remove(temp.size() - 1);

		    temp.set(temp.size() - 1, last.concat(strCur));
		    generateIp(i + 1, s, temp, result);
		    temp.set(temp.size() - 1, last);
		}
	    }
	} else if (temp.size() == 4) {
	    String last = temp.get(temp.size() - 1);
	    int lastInt = Integer.valueOf(last);
	    if (last.length() >= 3 || last.equals("0")) {
		return;
	    } else if (last.length() == 1 || last.length() == 2) {
		if (lastInt * 10 + cur > 255) {
		    return;
		} else {
		    temp.set(temp.size() - 1, last.concat(strCur));
		    generateIp(i + 1, s, temp, result);
		    temp.set(temp.size() - 1, last);
		}
	    }
	} else {
	    return;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.restoreIpAddresses("25525511135");
    }
}
