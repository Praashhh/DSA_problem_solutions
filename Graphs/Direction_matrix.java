//Assume a matrix containing directions from {up, down, right, left} and
//you want to check if you can reach to a location from 0,0 to N,N.
//How would you do that?
//
//To solve this problem of checking if you can reach from the top-left corner (0, 0) to the bottom-right corner (N, N) of a matrix that contains directions like {up, down, right, left}, we can use Depth-First Search (DFS) or Breadth-First Search (BFS). These algorithms will help us traverse the matrix based on the directions provided and check if we can eventually reach the bottom-right corner.
//
//Approach:
//Matrix Representation: Each cell in the matrix contains one of four directions:
//
//up: Move to the cell directly above.
//down: Move to the cell directly below.
//left: Move to the cell directly to the left.
//right: Move to the cell directly to the right.
//DFS/BFS Traversal: Start at (0, 0) and explore in the direction specified by the current cell. Continue this exploration recursively (for DFS) or iteratively (for BFS) until you either reach the target cell (N, N) or determine that no path exists.
//
//Visited Cells: Use a visited matrix or set to avoid cycles (revisiting the same cell multiple times) and infinite loops.
//
//Edge Cases:
//
//If there’s no valid direction from a cell, return false.
//If you go out of bounds, stop that direction's traversal.

public class Solution {
    private int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, 1},   // right
            {0, -1}   // left
    };

    private HashMap<String, int[]> dirMap = new HashMap<>();

    public boolean canReachEnd(String[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        boolean[][] visited = new boolean[N][M];

        // Mapping the direction to index in directions array
        dirMap.put("up", directions[0]);
        dirMap.put("down", directions[1]);
        dirMap.put("right", directions[2]);
        dirMap.put("left", directions[3]);

        // Start DFS from (0, 0)
        return dfs(matrix, 0, 0, visited);
    }

    private boolean dfs(String[][] matrix, int x, int y, boolean[][] visited) {
        int N = matrix.length;
        int M = matrix[0].length;

        // If we reached the bottom-right corner, return true
        if (x == N - 1 && y == M - 1) {
            return true;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Get the direction from the current cell
        String direction = matrix[x][y];

        // Get the move associated with that direction
        int[] move = dirMap.get(direction);

        // Calculate the next cell based on the direction
        int newX = x + move[0];
        int newY = y + move[1];

        // Check if the next cell is within bounds and not visited
        if (isValid(newX, newY, N, M) && !visited[newX][newY]) {
            if (dfs(matrix, newX, newY, visited)) {
                return true;
            }
        }

        // If no path was found from this cell, return false
        return false;
    }

    // Helper function to check if coordinates are within bounds
    private boolean isValid(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
