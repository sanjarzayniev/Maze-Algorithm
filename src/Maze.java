import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static boolean solveMaze(char[][] maze, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();

            if (currentCell[0] == end[0] && currentCell[1] == end[1]) {
                return true;  // Maze is solvable
            }

            String key = currentCell[0] + "," + currentCell[1];
            if (!visited.contains(key)) {
                visited.add(key);
                int[][] neighbors = getNeighbors(currentCell, maze);
                for (int[] neighbor : neighbors) {
                    queue.offer(neighbor);
                }
            }
        }

        return false;  // No path to the exit
    }

    private static int[][] getNeighbors(int[] cell, char[][] maze) {
        // Implement the logic to get neighboring cells based on the maze structure
        // ...
        return null;
    }

    public static void main(String[] args) {
        // Example usage:
        char[][] maze = {
            {'S', '.', '.', '#', '#'},
            {'.', '#', '.', '.', '#'},
            {'.', '#', '#', '.', '#'},
            {'.', '.', '.', '#', '.'},
            {'#', '#', '#', '#', 'E'}
        };
        int[] start = {0, 0};
        int[] end = {4, 4};

        boolean isSolvable = solveMaze(maze, start, end);
        System.out.println("Is the maze solvable? " + isSolvable);
    }
}
