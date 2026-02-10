class Solution {
    
    private int canFinishEating(int s , int[] arr) {
        int totalReqTime = 0;
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++) {
            int quo = arr[i] / s;
            int rem = arr[i] % s;
            if(rem != 0){
                totalReqTime++;
            }
            totalReqTime += quo;
        }
        return totalReqTime;
    }
    
    public int kokoEat(int[] arr, int k) {
        
        int minRate = -1;
        int left = 1;
        int right = (int)1e6;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canFinishEating(mid , arr) <= k) {
                minRate = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minRate;
    }
}
