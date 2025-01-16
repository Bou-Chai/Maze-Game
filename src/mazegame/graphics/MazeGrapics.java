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
    int magnificationFactor = 7; // 25 for 30
    int disX = 400;
    int disY = 10;               // 30 for 30
    int wallSpacing = 6;         // 22 for 30
    double windowWidth;
    double windowHeight;

    public MazeGrapics(JFrame window, Graph<Point> mazeGraph) {
        this.window = window;
        this.mazeGraph = mazeGraph;
        nodeNum = mazeGraph.getNumNodes();
    }
    
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        windowWidth = window.getBounds().getWidth();
        windowHeight = window.getBounds().getHeight();

        currentPoint = mazeGraph.getNodeData(0);

        //g2.setStroke(new BasicStroke(wallSpacing));
        //g2.setColor(Color.CYAN);
        //g2.drawRect(disX, disY, 100 * magnificationFactor, 100 * magnificationFactor);
        
        // Draw the maze by looping through the maze graph, connecting node points with lines
        for (currentNodeIndex = 0; currentNodeIndex < nodeNum; currentNodeIndex++) {

            currentPoint = mazeGraph.getNodeData(currentNodeIndex);
            //currentPoint.addX(disX);
            //currentPoint.addY(disY);

            for (int edgeIndex = 0; edgeIndex < mazeGraph.getNode(currentNodeIndex).getNumEdges(); edgeIndex++) {
                nextNodeIndex = mazeGraph.getNode(currentNodeIndex).getEdge(edgeIndex).getNodeIndex();

                if (nextNodeIndex < currentNodeIndex - 1 || nextNodeIndex == currentNodeIndex + 1) {
                    nextPoint = mazeGraph.getNodeData(nextNodeIndex);
                    //nextPoint.addX(disX);
                    //nextPoint.addY(disY);

                    g2.setColor(Color.RED);
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
        currentPoint = mazeGraph.getNodeData(0);
        g2.setColor(Color.GREEN);
        startPoint.setX(currentPoint.getX());
        startPoint.setY(currentPoint.getY());
        g2.drawLine(startPoint.getX(), startPoint.getY(), mazeGraph.getNodeData(1).getX(), mazeGraph.getNodeData(1).getY());
        
        // Draw end point
        g2.setColor(Color.BLUE);
        currentPoint = mazeGraph.getNodeData(nodeNum - 1);
        endPoint.setX(currentPoint.getX());
        endPoint.setY(currentPoint.getY());
        g2.drawLine(endPoint.getX(), endPoint.getY(), mazeGraph.getNodeData(mazeGraph.getEdge(nodeNum - 1, 0).getNodeIndex()).getX(), mazeGraph.getNodeData(mazeGraph.getEdge(nodeNum - 1, 0).getNodeIndex()).getY());
/*
        g.setColor(Color.WHITE);
        g.drawLine(0, 100, 500, 100);
        g.drawLine(0, 100 + wallSpacing, 500, 100 + wallSpacing);
*/
    }
}
