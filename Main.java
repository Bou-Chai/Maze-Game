// Maze Game
// Tyseer Ammar Shahriar
// Date created: August 14, 2024
// Date last updated: December 29, 2024

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

class Main {

    public static void main(String args[]) {
        
        JFrame window = new JFrame();
        window.setSize(400, 500);
        window.getContentPane().setBackground(Color.BLACK);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setVisible(true);

        Maze maze = new Maze(100);
        maze.generate();
        maze.printGraphicsMatrix();
    }
/*
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
*/
}
