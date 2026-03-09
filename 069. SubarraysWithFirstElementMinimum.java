class Solution {
    public int countSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        int totalValidSubarrays = 0;
        for (int i = 0; i < n; i++) {
            totalValidSubarrays += (nse[i] - i);
        }
        
        return totalValidSubarrays;
    }
}

