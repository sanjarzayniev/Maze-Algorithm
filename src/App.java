import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class App {
    public static boolean solveMaze(char[][] maze, int[] start, int[] end) {
        Stack<int[]> stack = new Stack<>();
        HashSet<String> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int[] currentCell = stack.pop();
            
            if (currentCell[0] == end[0] && currentCell[1] == end[1]) {
                return true; // Maze is solvable
            }

            String key = currentCell[0] + "," + currentCell[1];
            if (!visited.contains(key)) {
                visited.add(key);
                int[][] neighbors = getNeighbors(currentCell, maze);
                for (int[] neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }

        return false; // No path to the exit
    }

    private static int[][] getNeighbors(int[] cell, char[][] maze) {
        int row = cell[0];
        int col = cell[1];
        int numRows = maze.length;
        int numCols = maze[0].length;

        int[][] neighbors = {
                { row - 1, col }, // Up
                { row + 1, col }, // Down
                { row, col - 1 }, // Left
                { row, col + 1 } // Right
        };

        List<int[]> validNeighbors = new ArrayList<>();

        for (int[] neighbor : neighbors) {
            int newRow = neighbor[0];
            int newCol = neighbor[1];

            // Check if the neighbor is within the maze boundaries and is a valid cell to
            // move to
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols &&
                    maze[newRow][newCol] != '#') {
                validNeighbors.add(neighbor);
            } else {
                System.out.println("NOT: " + Arrays.toString(neighbor));
            }
        }

        return validNeighbors.toArray(new int[0][0]);
    }

    public static String isSolvableMethod(boolean isSolvable) {
        if (isSolvable) {
            return "Yes!";
        } else {
            return "No!";
        }
    }

    public static void main(String[] args) {
        // Example usage:
        char[][] maze = {
                { 'S', '.', '.', '#', '#' },
                { '.', '#', '.', '.', '#' },
                { '.', '#', '#', '.', '#' },
                { '.', '.', '.', '#', '.' },
                { '#', '#', '#', '.', 'E' }
        };
        int[] end = { 4, 4 };
        int[] start = { 0, 0 };

        boolean isSolvable = solveMaze(maze, start, end);

        System.out.println("Is the maze solvable: " + isSolvableMethod(isSolvable));
    }
}
