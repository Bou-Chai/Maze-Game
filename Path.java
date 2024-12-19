// Class defining maze paths
// Tyseer Ammar Shahriar
// Date created: August 17, 2024 (On the plane on the way to Colorado!)
// Date last updated: August 28, 2024

import java.util.Random;

class Path {
    // Declare variables
    private int node1X;
    private int node1Y;
    private int node2X;
    private int node2Y;
    private int coords[][];
    private Random rd = new Random();

    // Constructor
    public Path(int node1X, int node1Y, int node2X, int node2Y) {
        this.node1X = node1X;
        this.node1Y = node1Y;
        this.node2X = node2X;
        this.node2Y = node2Y;
    }

    // Method to generate path coords
    public generatePath(int matrixSize) {
        // Determine number of sub-paths and initialize coords array
        int randomSubPathNum = Math.random() * (matrixSize / 10);
        int coordNum = randomSubPathNum + 2;
        coords = new int[coordNum][2];

        // First and last coordinates are always the location of first and last nodes
        coords[0][0] = node1X;
        coords[0][1] = node1Y;
        coords[coordNum - 1][0] = node2X;
        coords[coordNum - 1][1] = node2Y;

        // Random sub-path generation
        for (int i = 0; i < randomSubPathNum; i++) {
            if (rd.nextBoolean()) {
                // Generate horizontal sub-path
                coords[i + 1][]
                // Y values stay the same for horizontal path
                coords[i + 1][1] = coords[i][1];
            } else {
                // Generate vertical sub-path
            }
        }

        // Honing generation
    }

    // Method to return path size
    public int getPathSize() {
        return this.coords.length;
    }
}

// 1. specify matrix size
// 2. randomly select start and end of maze, making the two points nodes
// 3. generate path from start node to end node
// 4. randomly select other nodes
// 5. randomly generate paths between other nodes

// (remember to add nodes and paths to graph data structure)
// (remember to add paths and nodes to graphics matrix)

// A random number of subpaths will be random, then begin to hone in
