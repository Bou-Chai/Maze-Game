package mazegame.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import mazegame.view.graphics.MazeGrapics;
import mazegame.model.Model;

public class View {
    JFrame window;
    Model model;
    JButton play = new JButton("PLAY");
    JButton settings = new JButton("SETTINGS");

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
        System.out.println("view updated");
    }

    public void paintStartMenu() {
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.WHITE);
        play.setBorder(BorderFactory.createEmptyBorder());

        settings.setBackground(Color.BLACK);
        settings.setForeground(Color.WHITE);
        settings.setBorder(BorderFactory.createEmptyBorder());
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);

        window.setLayout(new GridLayout(3, 1));
        window.add(play);
        window.add(Box.createGlue());
        window.add(settings);
        window.revalidate();
        window.repaint();
    }

    public void paintExitPrompt() {
        ;
    }

    public void paintMaze() {
        // Clear the window before painting the maze
        System.out.println("Here");
        window.getContentPane().removeAll();
        window.revalidate();
        window.repaint();
        
        window.setLayout(new BorderLayout());
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

    public JButton getPlayButton() {
        return play;
    }

    public JButton getSettingsButton() {
        return settings;
    }
}
