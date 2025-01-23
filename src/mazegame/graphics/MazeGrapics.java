// Class to display maze
// Tyseer Ammar Shahriar
// Date created: January 6, 2025
// Date last updated: January 14, 2025

package mazegame.graphics;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import mazegame.util.graph.Graph;
import mazegame.mazegeneration.Point;;

public class MazeGrapics extends Canvas {

    JFrame window;
    Rectangle r;
    Graph<Point> mazeGraph;
    Point currentPoint = new Point(0, 0);
    Point nextPoint = new Point(0, 0);
    Point endPoint = new Point(0, 0);
    Point startPoint = new Point(0, 0);
    int currentNodeIndex;
    int nextNodeIndex = 1; 
    int nodeNum;
    int wallSpacing;         // 22 for 30

    public MazeGrapics(JFrame window, Graph<Point> mazeGraph, int wallSpacing) {
        this.window = window;
        this.mazeGraph = mazeGraph;
        this.wallSpacing = wallSpacing;
        nodeNum = mazeGraph.getNumNodes();
    }
    
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        currentPoint = mazeGraph.getNodeData(0);

        //g2.setStroke(new BasicStroke(wallSpacing));
        //g2.setColor(Color.CYAN);
        //g2.drawRect(disX, disY, 100 * magnificationFactor, 100 * magnificationFactor);
        
        // Draw the maze by looping through the maze graph, connecting node points with lines
        for (currentNodeIndex = 0; currentNodeIndex < nodeNum; currentNodeIndex++) {

            currentPoint = mazeGraph.getNodeData(currentNodeIndex);

            for (int edgeIndex = 0; edgeIndex < mazeGraph.getNode(currentNodeIndex).getNumEdges(); edgeIndex++) {
                nextNodeIndex = mazeGraph.getNode(currentNodeIndex).getEdge(edgeIndex).getNodeIndex();

                if (nextNodeIndex < currentNodeIndex - 1 || nextNodeIndex == currentNodeIndex + 1) {
                    nextPoint = mazeGraph.getNodeData(nextNodeIndex);

                    g2.setColor(Color.GRAY);
                    g2.setStroke(new BasicStroke(wallSpacing));

                    g2.drawLine(currentPoint.getX(), 
                                currentPoint.getY(),
                                nextPoint.getX(),
                                nextPoint.getY());

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (Exception e) {

                    }
                }
            }
        }

        // Draw start point
        g2.setColor(Color.GREEN);
        g2.fillRect(mazeGraph.getNodeData(0).getX() - wallSpacing / 2, mazeGraph.getNodeData(0).getY() - wallSpacing / 2, wallSpacing + 1, wallSpacing + 1);
        // Draw end point
        g2.setColor(Color.BLUE);
        g2.fillRect(mazeGraph.getNodeData(nodeNum - 1).getX() - wallSpacing / 2, mazeGraph.getNodeData(nodeNum - 1).getY() - wallSpacing / 2, wallSpacing + 1, wallSpacing + 1);

    }
}
