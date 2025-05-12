// Maze Game controller class
// Tyseer Ammar Shahriar
// Date created: May 10, 2025
// Date last updated: May 10, 2025

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.text.View;

import mazegame.graphics.MazeGrapics;
import mazegame.mazegeneration.Maze;

public class GameController {

    Model model;
    View view;

    GameController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initGame() {
        // Game loop
        while (true) {
            // SwingUtilities.invokeLater(view.update());
            // Update model
        }

        //Player player = new Player();
        
        JFrame window = new JFrame();

        window.setSize(700, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.getContentPane().setBackground(Color.BLACK);
        window.setExtendedState(Frame.MAXIMIZED_BOTH);

        // Get window bounds
        windowWidth = window.getBounds().getWidth();
        windowHeight = window.getBounds().getHeight();

        // Create model
        Model model = new Model();
        model.init(mazeSize, windowWidth, windowHeight);
        //Maze maze = new Maze(mazeSize);

        // maze.generate();
        //maze.printGraphicsMatrix();

        MazeGrapics mGraphic = new MazeGrapics(window, maze.getMazeGraph(), wallSpacing);
        window.add(mGraphic);
    }

    private
}
