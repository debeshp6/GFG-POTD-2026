class Solution {
    public String firstNonRepeating(String s) {
        
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++; 
            q.offer(ch); 
        
            while(!q.isEmpty() && freq[q.peek()-'a']>1) q.poll();
            
            if(q.isEmpty()) ans.append('#'); 
            else ans.append(q.peek());
        }
        
        return ans.toString();
    }
}
