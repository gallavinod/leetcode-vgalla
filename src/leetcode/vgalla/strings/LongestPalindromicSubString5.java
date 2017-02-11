package leetcode.vgalla.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestPalindromicSubString5 {
	
	public static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static String longestPalindrome(String s) {
		String longestString = "";
		int n = s.length();
		if (n>0) {
			longestString = s.substring(0, 1);
			for (int i=0; i<n; i++) {
				List <Integer> matches = new ArrayList <Integer> ();
				for (int j=i+1; j<n; j++) {
					if (s.charAt(i) == s.charAt(j)) {
						matches.add(j);
					}
				}
				if (matches.size() > 0) {
					Collections.sort(matches, Collections.reverseOrder());
					for (int end: matches) {
						if (isPalindrome(s, i,end)) {
							if ((end-i+1) > longestString.length()) {
								longestString = s.substring(i, end+1);
								break;
							}
						}
					}
				}
			}
		}
		return longestString;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abcdedcabc"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome(""));
		System.out.println(longestPalindrome("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
	}
}
