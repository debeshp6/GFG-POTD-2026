class Solution {
    
    public int sumOfDig(int n) {
        int sum = 0;
        while(n>0) {
            int dig = n%10;
            sum += dig;
            n = n/10;
        }
        return sum;
    }
    
    public int getCount(int n, int d) {
        int s = 1; 
        int e = n; 
        int temp = 0; 
        
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(mid - sumOfDig(mid)>=d) { 
                temp = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return temp==0? 0 : n - temp + 1;
    }
};
