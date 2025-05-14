package mazegame.model;

import mazegame.mazegeneration.Maze;

public class Model {
    Maze maze;
    double mazeMagnificationFactor;
    int mazeWallSpacing;
    double mazeLength;
    double mazeDisX;
    double mazeDisY;
    int mazeSize;
    boolean playMode = false;


    public Model(int mazeSize, int windowWidth, int windowHeight) {
        // Generate maze
        maze = new Maze(mazeSize);

        maze.generate();
        maze.printGraphicsMatrix();

        refactor(windowWidth, windowHeight);

        // Initialize entities
        //player.setX(maze.);
    }

    public void update() {
        ;
    }

    public void refactor(int windowWidth, int windowHeight) {

        // Calculate the magnification so that the maze fills the screen height-wise
        mazeSize = maze.getSize();
        mazeMagnificationFactor = windowHeight / mazeSize;
        mazeWallSpacing = ((int) mazeMagnificationFactor) - 1;
        mazeLength = mazeSize * mazeMagnificationFactor;

        // Center the maze
        mazeDisX = (windowWidth / 2) - (mazeLength / 2);
        mazeDisY = ((windowHeight / 2) - (mazeLength / 2)) - 15;

        // Apply the changes to the maze and add maze to window
        maze.refactor((int) mazeDisX, (int) mazeDisY, (int) mazeMagnificationFactor);
    }

    public void regenerateMaze(int mazeSize, int windowWidth, int windowHeight) {
        // Generate maze
        maze = new Maze(mazeSize);

        maze.generate();
        maze.printGraphicsMatrix();

        refactor(windowWidth, windowHeight);

        // Initialize entities
        //player.setX(maze.);
    }

    public Maze getMaze() {
        return maze;
    }

    public int getMazeWallSpacing() {
        return mazeWallSpacing;
    }

    public boolean getPlayMode() {
        return playMode;
    }

    public void setPlayMode(boolean playMode) {
        this.playMode = playMode;
    }
}
