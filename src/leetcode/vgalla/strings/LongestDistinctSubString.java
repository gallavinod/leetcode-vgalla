package leetcode.vgalla.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubString {
	
	public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int N = s.length();
        if (N > 0) {
            int currEnd = 0;
            int currStart = 0;
            int maxStart = 0;
            int maxEnd = 0;
            Map <Character, Integer> map = new HashMap <Character, Integer> ();
            while (currEnd < N) {
                char c = s.charAt(currEnd);
                if (map.containsKey(c)) {
                    int conflictIndex = map.get(c);
                    for (int i=currStart; i<= conflictIndex; i++) {
                        map.remove(s.charAt(i));
                    }
                    map.put(c, currEnd);
                    currStart = conflictIndex + 1;
                } else {
                    map.put(c, currEnd);
                    if ((currEnd - currStart +1) > maxLength) {
                        maxStart = currStart;
                        maxEnd = currEnd;
                        maxLength = (currEnd - currStart + 1);
                    }
                }
                currEnd++;
            }
            System.out.println(s.substring(maxStart, maxEnd+1));
        }
        return maxLength;
    }
	
	public static void main(String[] args) {
		
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));

	}
}
