class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0, time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] == 1) {
                        mat[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                        freshCount--;
                        rotted = true;
                    }
                }
            } if (rotted) time++;
        } return freshCount == 0 ? time : -1;
    }
}
