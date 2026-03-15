/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    int count = 0;
    HashMap<Long, Integer> map = new HashMap<>();
    
    public int countAllPaths(Node root, int k) {
        map.put(0L, 1); 
        dfs(root, 0L, k);
        return count;
    }
    
    private void dfs(Node node, long currSum, int k) {
        if (node == null) return;
        currSum += node.data;
        if (map.containsKey(currSum - k)) {
            count += map.get(currSum - k);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        dfs(node.left, currSum, k);
        dfs(node.right, currSum, k);
        map.put(currSum, map.get(currSum) - 1); 
    }
}
