class Solution {
    public boolean canFinish(int n, int[][] edges) {
       
        List<List<Integer>> adj = new ArrayList<>();
        var indegree = new int[n];
        
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            adj.get(v).add(u);
        }
        
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            
            for (Integer neigh : adj.get(node)) {
                if (--indegree[neigh] == 0)
                    q.offer(neigh);
            }
        }
        
        return (cnt == n);
    }
}
