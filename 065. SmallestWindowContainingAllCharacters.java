class Solution {
    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        
        int[] countP = new int[26];
        int[] countWin = new int[26];
        
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }
        
        int required = p.length();
        int formed = 0;
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            countWin[c - 'a']++;
            
            if (countP[c - 'a'] > 0 && countWin[c - 'a'] <= countP[c - 'a']) {
                formed++;
            }
            
            while (formed == required && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                countWin[leftChar - 'a']--;
                
                if (countP[leftChar - 'a'] > 0 && countWin[leftChar - 'a'] < countP[leftChar - 'a']) {
                    formed--;
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
