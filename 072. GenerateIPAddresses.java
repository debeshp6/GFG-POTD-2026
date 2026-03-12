

class Solution {
    
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }
    
    private void backtrack(String s, int start, int segmentCount, String currentIP, ArrayList<String> result) {
        if (segmentCount == 4 && start == s.length()) {
            result.add(currentIP);
            return;
        }
       
        if (segmentCount == 4 || start == s.length()) {
            return;
        }
       
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) {
                break;
            }
         
            String segment = s.substring(start, start + len);
    
            if ((segment.length() > 1 && segment.charAt(0) == '0') || Integer.parseInt(segment) > 255) {
                continue;
            }

            String newIP = currentIP.isEmpty() ? segment : currentIP + "." + segment;
        
            backtrack(s, start + len, segmentCount + 1, newIP, result);
        }
    }
}
