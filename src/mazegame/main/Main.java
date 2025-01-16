// Maze Game
// Tyseer Ammar Shahriar
// Date created: August 14, 2024
// Date last updated: January 6, 2025

package mazegame.main;

import mazegame.mazegeneration.Maze;
import mazegame.graphics.MazeGrapics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

class Main {

    public static void main(String args[]) {
        int magnificationFactor = 7; // 25 for 30
        int disX = 400;
        int disY = 50;

        // Generate maze
        Maze maze = new Maze(100);
        maze.generate();
        maze.printGraphicsMatrix();
        
        JFrame window = new JFrame();
        maze.refactor(disX, disY, magnificationFactor);
        MazeGrapics mGraphic = new MazeGrapics(window, maze.getMazeGraph());

        window.setSize(400, 500);
        window.getContentPane().setBackground(Color.BLACK);
        window.add(mGraphic);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setVisible(true);
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
