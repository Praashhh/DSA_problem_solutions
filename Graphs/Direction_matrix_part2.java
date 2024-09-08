//Now lets say you can change the directions, and you've to find the minimum number of
//directions to change to reach the destination. How would you approach this question?

//If you are allowed to change the directions in the matrix and need to find the minimum number
//of changes required to reach the destination (N, N) from (0, 0), this problem can be approached
//using Dijkstra's Algorithm or a BFS-like shortest path algorithm with a priority queue (min-heap).
//
//The key idea is to treat each direction change as a "cost" and find the path with the minimum cost,
//where the cost represents the number of direction changes needed.
//
//Approach:
//Cost Representation:
//
//We treat the matrix as a graph where each cell is a node.
//Moving from one cell to another is considered an edge, and changing the direction incurs a cost of 1.
//If we don't need to change the direction, the cost is 0.
//Dijkstra's Algorithm (or BFS with priority queue):
//
//Use a priority queue to always explore the cell with the smallest cost (minimum number of direction changes so far).
//For each cell, check its four possible neighbors (up, down, left, right). If moving to a neighbor requires
//changing the direction (i.e., the direction stored in the current cell is not aligned with the direction needed to move to that neighbor), we add a cost of 1. Otherwise, the cost remains the same.
//Keep track of the minimum number of direction changes for each cell.
//Algorithm Outline:
//
//Start from (0, 0) with a cost of 0.
//Explore all neighboring cells and calculate the cost to reach them. If the cost to reach a neighbor is
//smaller than the previously known cost, update it and add the cell to the priority queue.
//Continue this process until you reach the bottom-right corner (N, N).

import java.util.PriorityQueue;

public class Solution {
    private int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, 1},   // right
            {0, -1}   // left
    };

    private HashMap<String, int[]> dirMap = new HashMap<>();
    private String[] dirStr = {"up", "down", "right", "left"}; // String directions

    public int minChangesToReachEnd(String[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        // Min-heap to store (cost, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 2D array to store minimum cost (direction changes) to reach each cell
        int[][] minCost = new int[N][M];

        // Initialize the minCost array with a large number (infinity)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        // Start from (0, 0) with cost 0
        pq.offer(new int[]{0, 0, 0});  // {cost, x, y}
        minCost[0][0] = 0;

        // Mapping the direction to index in directions array
        dirMap.put("up", directions[0]);
        dirMap.put("down", directions[1]);
        dirMap.put("right", directions[2]);
        dirMap.put("left", directions[3]);

        // BFS-style traversal with priority queue
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];

            // If we've reached the destination, return the cost
            if (x == N - 1 && y == M - 1) {
                return cost;
            }

            // Get the current direction from the matrix
            String currentDir = matrix[x][y];

            // Try all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int[] move = directions[i];
                int newX = x + move[0];
                int newY = y + move[1];

                // Check if the new coordinates are valid
                if (isValid(newX, newY, N, M)) {
                    // Determine the new cost
                    int newCost = cost;
                    // If moving in the current direction doesn't match the matrix direction, we incur a cost
                    if (!dirStr[i].equals(currentDir)) {
                        newCost++;
                    }

                    // If the new cost is lower than the previously known cost for this cell, update and add to queue
                    if (newCost < minCost[newX][newY]) {
                        minCost[newX][newY] = newCost;
                        pq.offer(new int[]{newCost, newX, newY});
                    }
                }
            }
        }

        // If we exhaust the queue without reaching (N-1, M-1), return -1
        return -1;
    }

    // Helper function to check if coordinates are within bounds
    private boolean isValid(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
