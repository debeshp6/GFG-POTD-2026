class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
        if(s1.length() != s2.length()) return false;
        
        Map<Character, Character> s1Tos2 = new HashMap<>();
        Map<Character, Character> s2Tos1 = new HashMap<>();
        
        for(int i=0; i<s1.length(); i++) {
            char cs1 = s1.charAt(i);
            char cs2 = s2.charAt(i);
            
            if(s1Tos2.containsKey(cs1) && s1Tos2.get(cs1) != cs2) return false;
            if(s2Tos1.containsKey(cs2) && s2Tos1.get(cs2) != cs1) return false;
            else {
                s1Tos2.put(cs1, cs2);
                s2Tos1.put(cs2, cs1);
            }
        }
        
        return true;
    }
}
