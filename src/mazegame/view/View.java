package mazegame.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.SwingUtilities;

import mazegame.view.graphics.MazeGrapics;
import mazegame.model.Model;

public class View {
    JFrame window;
    Model model;

    public View() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                window = new JFrame();
                window.setSize(700, 500);
                window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                window.setVisible(true);
                window.getContentPane().setBackground(Color.BLACK);
                window.setExtendedState(Frame.MAXIMIZED_BOTH);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() throws IllegalStateException {
        if (model == null) {
            throw new IllegalStateException("Model must be set in order to update the view");
        }

    }

    public void paintMaze() {
        MazeGrapics mGraphic = new MazeGrapics(model.getMaze().getMazeGraph(), model.getMazeWallSpacing());
        window.add(mGraphic);
        window.revalidate();
        window.repaint();
    }

    public JFrame getWindow() {
        return window;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
