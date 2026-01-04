class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        // Compute sum of first k elements
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;
        
        // Slide the window
        for (int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
