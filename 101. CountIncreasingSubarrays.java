class Solution {
    public int countIncreasing(int[] arr) {
        
        int n = arr.length;
        int totalCount = 0;
        int left = 0;

        for (int right = 1; right < n; right++) {
            if (arr[right] <= arr[right - 1]) {
                left = right; 
            }
            if (right > left) {
                totalCount += (right - left);
            }
        }

        return totalCount;
    }
}
