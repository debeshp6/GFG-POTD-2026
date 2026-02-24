
// User function Template for Java

class Solution {
    static int longestSubarray(int[] arr, int k) {
        
        int n = arr.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (arr[i] > k) ? 1 : -1;
        }

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];

            if (prefixSum > 0) {
                maxLength = i + 1;
            }

            if (prefixSumMap.containsKey(prefixSum - 1)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - 1));
            }

            prefixSumMap.putIfAbsent(prefixSum, i);
        }

        return maxLength;
    }
}




