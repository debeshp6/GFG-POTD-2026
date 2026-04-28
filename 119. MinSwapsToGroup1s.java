class Solution { 
    public int minSwaps(int[] arr) {
        int numOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                numOnes++;
            }
        }
        
        if (numOnes == 0) {
            return -1;
        }
        
        int start = 0;
        int end = 0;
        int checkOnes = 0;
        int mini = Integer.MAX_VALUE;
        while (end < arr.length) {
            if (arr[end] == 1) {
                checkOnes++;
            }
            while (start < arr.length && (end - start + 1) > numOnes) {
                if (arr[start] == 1) {
                    checkOnes--;
                }
                start++;
            }
            if (numOnes == checkOnes) {
                return 0;
            }
            if (numOnes > checkOnes) {
                mini = Math.min(mini, numOnes - checkOnes);
            }
            end++;
        }
        return mini;
    }
}
