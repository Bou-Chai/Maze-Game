import mazegame.mazegeneration.Maze;

public class Model {
    Maze maze;

    Model() {

    }

    public void init(int mazeSize) {
        double magnificationFactor;
        int wallSpacing;
        double mazeLength;
        double disX;
        double disY;
        double windowWidth;
        double windowHeight;
        
        // Generate maze
        maze = new Maze(mazeSize);

        maze.generate();
        maze.printGraphicsMatrix();

        // Calculate the magnification so that the maze fills the screen height-wise
        magnificationFactor = windowHeight / mazeSize;
        wallSpacing = ((int) magnificationFactor) - 1;
        mazeLength = mazeSize * magnificationFactor;

        // Center the maze
        disX = (windowWidth / 2) - (mazeLength / 2);
        disY = (windowHeight / 2) - (mazeLength / 2);

        // Apply the changes to the maze and add maze to window
        maze.refactor((int) disX, (int) disY, (int) magnificationFactor);

        // Initialize entities
        //player.setX(maze.);
    }

    public Maze getMaze() {
        return maze;
    }
}
