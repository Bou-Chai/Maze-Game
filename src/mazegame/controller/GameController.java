// Maze Game controller class
// Tyseer Ammar Shahriar
// Date created: May 10, 2025
// Date last updated: May 10, 2025

package mazegame.controller;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import mazegame.graphics.MazeGrapics;
import mazegame.mazegeneration.Maze;
import mazegame.model.Model;
import mazegame.view.View;

public class GameController {

    Model model;
    View view;

    public GameController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void runGame() {
        // Game loop
        SwingUtilities.invokeLater(() -> {view.paintMaze();});
        while (true) {
            SwingUtilities.invokeLater(() -> {view.update();});
            model.update();
            System.out.println("Test");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

        
    }

    //private
}
