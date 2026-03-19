// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    static int largestBst(Node root) {
        if (root == null) return 0;
        int[] maxSize = new int[1];
        helper(root, maxSize);
        return maxSize[0];
    }
    
    private static int[] helper(Node node, int[] maxSize) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // min, max, size
        }
        
        int[] left = helper(node.left, maxSize);
        int[] right = helper(node.right, maxSize);
       
        if (left[1] < node.data && node.data < right[0]) {
            int currSize = left[2] + right[2] + 1;
            maxSize[0] = Math.max(maxSize[0], currSize);
            return new int[]{
                Math.min(left[0], node.data),
                Math.max(right[1], node.data),
                currSize
            };
        }
        
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}
