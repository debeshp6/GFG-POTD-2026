class Solution {
    public int maxWater(int arr[]) {
        
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int leftWall = 0;
        int rightWall = 0;
        int water = 0;
        
        while(left <= right) {
            if(leftWall < rightWall) {
                leftWall = Math.max(arr[left], leftWall);
                water += leftWall - arr[left];
                left++;
            } else {
                rightWall = Math.max(arr[right], rightWall);
                water += rightWall - arr[right];
                right--;
            }
        }
        
        return water;
    }
}
