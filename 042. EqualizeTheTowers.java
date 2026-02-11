class Solution {
    
    boolean check(int[] heights , int[] cost , int mid) {
        long midCost = 0;
        long midCostp1 = 0;
        int n = heights.length;
        for(int i = 0 ; i < n ; i++){
            midCost += (long)(Math.abs(heights[i] - mid) * cost[i]);
            midCostp1 += (long)(Math.abs(heights[i] - (mid + 1)) * cost[i]);
        }
        return midCostp1 > midCost;
    }
    public int minCost(int[] heights, int[] cost) {
       
        int n = heights.length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            left = Math.min(left , heights[i]);
            right = Math.max(right , heights[i]);
        }
        
        int targetH = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(check(heights , cost , mid)) {
                targetH = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        long result = 0;
        for(int i = 0 ; i < n ; i++) {
            result += (long)(Math.abs(heights[i] - targetH) * cost[i]);
        }
        return (int)result;
    }
}
