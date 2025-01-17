// Maze Game
// Tyseer Ammar Shahriar
// Date created: August 14, 2024
// Date last updated: January 6, 2025

package mazegame.main;

import mazegame.mazegeneration.Maze;
import mazegame.graphics.MazeGrapics;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

class Main {

    public static void main(String args[]) {
        int mazeSize = 40;
        double magnificationFactor;
        int wallSpacing;
        double mazeLength;
        double disX;
        double disY;
        double windowWidth;
        double windowHeight;

        // Generate maze
        Maze maze = new Maze(mazeSize);

        maze.generate();
        maze.printGraphicsMatrix();
        
        JFrame window = new JFrame();

        //window.setSize(3000, 3000);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.getContentPane().setBackground(Color.BLACK);
        window.setExtendedState(Frame.MAXIMIZED_BOTH);

        windowWidth = window.getBounds().getWidth();
        windowHeight = window.getBounds().getHeight();

        magnificationFactor = windowHeight / mazeSize;
        wallSpacing = ((int) magnificationFactor) - 1;
        mazeLength = mazeSize * magnificationFactor;

        disX = (windowWidth / 2) - (mazeLength / 2);
        disY = (windowHeight / 2) - (mazeLength / 2);

        maze.refactor((int) disX, (int) disY, (int) magnificationFactor);
        MazeGrapics mGraphic = new MazeGrapics(window, maze.getMazeGraph(), wallSpacing);
        window.add(mGraphic);

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
