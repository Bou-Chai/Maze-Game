// Maze class
// Tyseer Ammar Shahriar
// Date created: August 26, 2024
// Date last updated: December 18, 2024
// DONT GENERATE START NODES ON CORNERS!!

import java.util.Random;
import java.util.Stack;
import util.graph.*;

class Maze {
    // Declare vairables
    private int size;
    private Point startNode;
    private int maxIndex;
    private boolean exitGenerated = false;
    private int numNodes;
 //   private int currentNodeX;
 //   private int currentNodeY;
    private int[][] graphicsMatrix;
    private Stack<Point> nodeStack = new Stack<Point>();
    private Stack<Integer> nodeNumStack = new Stack<Integer>();
    private Graph<Point> mazeGraph;
    private Random rd = new Random();
    private int nodeCount = 0;

    // Constructor
    public Maze(int size) {
        this.size = size;
        maxIndex = size - 1;
        graphicsMatrix = new int[size][size];
    }

    // Method to generate maze
    public int generate() {
        
        // Generate main two nodes and main path
        startNode = genBoundaryNode();
        Point genNode;

        graphicsMatrix[startNode.y][startNode.x] = 1;

        nodeStack.push(startNode);
        //nodeNumStack.push(nodeCount);
        mazeGraph = new Graph<Point>(startNode);

        //System.out.println(nodeStack.peek());
        //System.out.println(mazeGraph.getNodeIndex(nodeStack.peek()));

        int count = 0;
        while (!nodeStack.empty()) {

            genNode = nodeStack.peek();
            
            System.out.printf("%d----------------------------------------------------------------------------\n", count);
            System.out.printf("(%d, %d)\n", genNode.x, genNode.y);
            //System.out.println(nodeStack);

            genRandomPath(genNode);
            nodeStack.pop();
            //nodeNumStack.pop();

            count++;
        }
        genExitNode();

        mazeGraph.print();

        return numNodes;
    }

    // Function to generate main path
    public static void genMainPath(Point node1, Node node2) {
        
    }

    // Function to generate random paths
    public void genRandomPath(Point node) {
        int[] order = new int[4];
        int continuation;
        Point currentNode = new Point(0, 0);
        Point initNode = new Point(0, 0);
        boolean upFail = false;
        boolean downFail = false;
        boolean leftFail = false;
        boolean rightFail = false;
        int pathLength = 0;

        currentNode.x = node.x;
        currentNode.y = node.y;
     
        while (!(upFail && downFail && leftFail && rightFail)) {
            upFail = false;
            downFail = false;
            leftFail = false;
            rightFail = false;

            order[0] = (int) Math.round(Math.random() * 4);
            order[1] = (int) Math.round(Math.random() * 4);
            order[2] = (int) Math.round(Math.random() * 4);
            order[3] = (int) Math.round(Math.random() * 4);

            for (int i: order) {
                continuation = (int) Math.round(Math.random() * (graphicsMatrix.length / 2));
                initNode.x = currentNode.x;
                initNode.y = currentNode.y;

                switch (i) {
                    case 0:
                        for (pathLength = 0; pathLength < continuation; pathLength++) {
                            if (!genUp(currentNode)) {
                                upFail = true;
                                break;
                            } else {
                                currentNode.y--;
                            }
                        }
                        break;
                    case 1:
                        for (pathLength = 0; pathLength < continuation; pathLength++) {
                            if (!genDown(currentNode)) {
                                downFail = true;
                                break;
                            } else {
                                currentNode.y++;
                            }
                        }
                        break;
                    case 2:
                        for (pathLength = 0; pathLength < continuation; pathLength++) {
                            if (!genLeft(currentNode)) {
                                leftFail = true;
                                break;
                            } else {
                                currentNode.x--;
                            }
                        }
                        break;
                    case 3:
                        for (pathLength = 0; pathLength < continuation; pathLength++) {
                            if (!genRight(currentNode)) {
                                rightFail = true;
                                break;
                            } else {
                                currentNode.x++;
                            }
                        }
                        break;
                    default:
                        break;
                }
                // Push current node onto stack upon switching path direction
                if (currentNode.x != initNode.x || currentNode.y != initNode.y) {

                    // Add current node to graph
                    //System.out.println(nodeStack.peek());
                    /*System.out.print("Peeked: ");
                    nodeStack.peek().print();

                    System.out.print("Current: ");
                    currentNode.print();

                    System.out.println("----------");
                    printGraph();
                    System.out.println("----------");*/
                    mazeGraph.addNode(
                        new Point(currentNode.x, currentNode.y), 
                        mazeGraph.getNodeIndex(nodeStack.peek(), 
                        new Comparison<Point>() {
                            @Override
                            public int compare(Point obj1, Point obj2) {
                                //obj1.print();
                                //System.out.print(" : ");
                                //obj2.print();
                                //System.out.print(obj1.equals(obj2));
                                if (obj1.equals(obj2)) {
                                    return 0;
                                } else {
                                    return -1;
                                }
                            }
                        }
                        ), 
                    pathLength);

                    //mazeGraph.addNode(currentNode, mazeGraph.getNodeIndex(nodeStack.peek()), pathLength);
                    nodeStack.push(new Point(currentNode.x, currentNode.y));
                    //nodeCount++;
                    //nodeNumStack.push(nodeCount);

                    System.out.printf("Pushed: (%d, %d)\n", currentNode.x, currentNode.y);

                    //graphicsMatrix[currentNode.y][currentNode.x] = 7;
                }
            }
        }
        // If the last node in the path touches the boundary, generate boundary node
        /*if (!exitGenerated) {
            genExitNode();
        }*/
    }

    // Function to generate honing path
    public static void genHoningPath(Point node1, Point node2) {

    }

    // Function to print maze graph data
    public void printGraph() {
        for (int i = 0; i < mazeGraph.getNumNodes(); i++) {
            System.out.printf("%d: ", i);
            Point point = (Point) mazeGraph.getNode(i).getData();
            point.print();
            System.out.println();
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Fundamental path generation functions
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Function to "move up"
    private boolean genUp(Point currentNode) {
        try {
            if (graphicsMatrix[currentNode.y - 1][currentNode.x] == 0 && graphicsMatrix[currentNode.y - 2][currentNode.x] == 0 && isClearHorizontally(new Point(currentNode.x, currentNode.y - 1))) {
                graphicsMatrix[currentNode.y - 1][currentNode.x] = 1;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Function to "move down"
    private boolean genDown(Point currentNode) {
        try {
            if (graphicsMatrix[currentNode.y + 1][currentNode.x] == 0 && graphicsMatrix[currentNode.y + 2][currentNode.x] == 0 && isClearHorizontally(new Point(currentNode.x, currentNode.y + 1))) {
                graphicsMatrix[currentNode.y + 1][currentNode.x] = 1;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Function to "move left"
    private boolean genLeft(Point currentNode) {
        try {
            if (graphicsMatrix[currentNode.y][currentNode.x - 1] == 0 && graphicsMatrix[currentNode.y][currentNode.x - 2] == 0 && isClearVertically(new Point(currentNode.x - 1, currentNode.y))) {
                graphicsMatrix[currentNode.y][currentNode.x - 1] = 1;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Function to "move right"
    private boolean genRight(Point currentNode) {
        try {
            if (graphicsMatrix[currentNode.y][currentNode.x + 1] == 0 && graphicsMatrix[currentNode.y][currentNode.x + 2] == 0 && isClearVertically(new Point(currentNode.x + 1, currentNode.y))) {
                graphicsMatrix[currentNode.y][currentNode.x + 1] = 1;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Funtion to check left and right sides during path generation
    private boolean isClearHorizontally(Point node) {
        if (graphicsMatrix[node.y][node.x - 1] == 1 || graphicsMatrix[node.y][node.x + 1] == 1) {
            return false;
        } else {
            return true;
        }
    }

    // Funtion to check sides above and below during path generation
    private boolean isClearVertically(Point node) {
        if (graphicsMatrix[node.y - 1][node.x] == 1 || graphicsMatrix[node.y + 1][node.x] == 1) {
            return false;
        } else {
            return true;
        }
    }

    // Function to generate a fresh boundary node
    private Point genBoundaryNode() {
        Point boundaryNode = new Point(0, 0);
        boolean success = false;

        while (!success) {
            if (rd.nextBoolean()) {
                boundaryNode.x = 1 + (int) (Math.random() * (maxIndex - 2));
                if (rd.nextBoolean()) {
                    boundaryNode.y = 0;
                } else {
                    boundaryNode.y = maxIndex;
                }
            } else {
                boundaryNode.y = 1 + (int) (Math.random() * (maxIndex - 2));
                if (rd.nextBoolean()) {
                    boundaryNode.x = 0;
                } else {
                    boundaryNode.x = maxIndex;
                }
            }
            if (graphicsMatrix[boundaryNode.y][boundaryNode.x] == 0) {
                success = true;
            }
        }
        return boundaryNode;
    }

    private void genExitNode() {
        Point boundaryNode;
        boolean success = false;
        
        while (!success) {
            success = true;
            boundaryNode = genBoundaryNode();
            if (boundaryNode.x == 0) {
                if (graphicsMatrix[boundaryNode.y][boundaryNode.x + 1] == 1) {
                    graphicsMatrix[boundaryNode.y][boundaryNode.x] = 1;
                    System.out.println("Exit Generated");
                }
            } else if (boundaryNode.x == maxIndex) {
                if (graphicsMatrix[boundaryNode.y][boundaryNode.x - 1] == 1) {
                    graphicsMatrix[boundaryNode.y][boundaryNode.x] = 1;
                    System.out.println("Exit Generated");
                }
            } else if (boundaryNode.y == 0) {
                if (graphicsMatrix[boundaryNode.y + 1][boundaryNode.x] == 1) {
                    graphicsMatrix[boundaryNode.y][boundaryNode.x] = 1;
                    System.out.println("Exit Generated");
                }
            } else if (boundaryNode.y == maxIndex) {
                if (graphicsMatrix[boundaryNode.y - 1][boundaryNode.x] == 1) {
                    graphicsMatrix[boundaryNode.y][boundaryNode.x] = 1;
                    System.out.println("Exit Generated");
                }
            } else {
                success = false;
            }
        }
    }

/* 
    private static void genExitNode(Node node) {
        if (node.x == maxIndex - 1) {
            graphicsMatrix[node.y][maxIndex] = 1;
        } else if (node.y == maxIndex - 1) {
            graphicsMatrix[maxIndex][node.x] = 1;
        } else if (node.x == 1) {
            graphicsMatrix[node.y][0] = 1;
        } else if (node.y == 1) {
            graphicsMatrix[0][node.x] = 1;
        }
    }
*/
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Print graphics matrix
    public void printGraphicsMatrix() {
        for (int[] row: graphicsMatrix) {
            for (int unit: row) {
                System.out.print(unit);
            }
            System.out.print("\n");
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Getters and setters
    public int getSize() {
        return this.size;
    }
}
