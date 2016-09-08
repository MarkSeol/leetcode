/**
 * Given "abcabcbb", the answer is "abc", which the length is 3. Given "bbbbb",
 * the answer is "b", with the length of 1. Given "pwwkew", the answer is "wke",
 * with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * @author Markxue
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int longestStart = 0;
        int longestEnd = 0;
        int currentLongestStart = 0;
        int currentLongestEnd = 0;
        // Not only alphabet
        boolean[] before = new boolean[255];
        // Change string to byte array
        byte[] b = s.getBytes();
        for (int i = 0; i < b.length; i++) {
            if (!before[b[i]]) {
                currentLongestEnd = i;
                if (currentLongestEnd - currentLongestStart > longestEnd - longestStart) {
                    longestEnd = currentLongestEnd;
                    longestStart = currentLongestStart;
                }
                before[b[i]] = true;
            } else {
                for (int j = currentLongestStart; j <= i; j++) {
                    if (b[j] == b[i]) {
                        // Set new start
                        currentLongestStart = j + 1;
                        break;
                    } else {
                        // Remove the exist status
                        before[b[j]] = false;
                    }
                }
            }

        }
        return longestEnd - longestStart + 1;
    }

    public static void main(String[] args) {
        String str = "";
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(str));
    }
}
