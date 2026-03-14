class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        // Map: horizontal distance → list of nodes in level order
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        // Queue for level order traversal: node + horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node node = p.node;
            int hd = p.hd;
            
            // Add node to its vertical line
            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.data);
            
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        
        // Collect all vertical lines from left to right
        for (ArrayList<Integer> list : map.values()) {
            result.add(list);
        }
        
        return result;
    }
    
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
