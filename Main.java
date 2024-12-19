// Maze Game
// Tyseer Ammar Shahriar
// Date created: August 14, 2024
// Date last updated: August 28, 2024

class Main {

    public static void main(String args[]) {
        Maze maze = new Maze(100);
        maze.generate();
        maze.printGraphicsMatrix();
    }

    private static void printMaze(int[][] maze) {

        for (int[] row: maze) {
            for (int unit: row) {
                System.out.print(unit);
            }
            System.out.print("\n");
        }
    }

    private static int[][] generateMaze(int size) {

        // Initialize variables
        int[][] maze = new int[size / 2][size];
        boolean previous = false;

        // Generate random nodes (intersections) in the maze
        for (int[] row: maze) {
            for (int unitLocation = 0; unitLocation < size; unitLocation++) {
                if ((Math.random() < 0.5) && !previous) {
                    row[unitLocation] = 1;
                    previous = true;
                } 
                else {
                    previous = false;
                }
            }
        }
        return maze;
    }
}
