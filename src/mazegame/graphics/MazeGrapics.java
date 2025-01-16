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
    GraphicsEnvironment env;
    GraphicsDevice screen;
    GraphicsConfiguration config;
    Rectangle r;
    Graph mazeGraph;
    Point currentPoint = new Point(0, 0);
    Point nextPoint = new Point(0, 0);
    int currentNodeIndex;
    int nextNodeIndex = 1; 
    int nodeNum;
    int magnificationFactor = 25;
    int disX = 400;
    int disY = 30;
    int wallSpacing = 22;

    public MazeGrapics(JFrame window, Graph<Point> mazeGraph) {
        this.window = window;
        this.mazeGraph = mazeGraph;
        nodeNum = mazeGraph.getNumNodes();
    }
    
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        wallSpacing = 22;
        currentPoint = (Point) mazeGraph.getNodeData(0);

        //g2.setStroke(new BasicStroke(wallSpacing));
        g2.setColor(Color.CYAN);
        g2.drawRect(disX, disY, 30 * magnificationFactor, 30 * magnificationFactor);
        
        // Draw the maze by looping through the maze graph, connecting node points with lines
        for (currentNodeIndex = 0; currentNodeIndex < nodeNum; currentNodeIndex++) {

            currentPoint = (Point) mazeGraph.getNodeData(currentNodeIndex);
            //currentPoint.addX(disX);
            //currentPoint.addY(disY);

            for (int edgeIndex = 0; edgeIndex < mazeGraph.getNode(currentNodeIndex).getNumEdges(); edgeIndex++) {
                nextNodeIndex = mazeGraph.getNode(currentNodeIndex).getEdge(edgeIndex).getNodeIndex();

                if (nextNodeIndex < currentNodeIndex - 1 || nextNodeIndex == currentNodeIndex + 1) {
                    nextPoint = (Point) mazeGraph.getNodeData(nextNodeIndex);
                    //nextPoint.addX(disX);
                    //nextPoint.addY(disY);

                    g2.setColor(Color.RED);
                    g2.setStroke(new BasicStroke(wallSpacing));
                    g2.drawLine((currentPoint.getX() * magnificationFactor) + disX, 
                            (currentPoint.getY() * magnificationFactor) + disY,
                            (nextPoint.getX() * magnificationFactor) + disX,
                            (nextPoint.getY() * magnificationFactor) + disY);
                    
                    try {
                        //TimeUnit.MILLISECONDS.sleep(10);
                    } catch (Exception e) {

                    }
                }
            }
        }

        // Indicate start and end points
        currentPoint = (Point) mazeGraph.getNodeData(0);
        g2.setColor(Color.GREEN);
        g2.fillOval((currentPoint.getX() * magnificationFactor) + disX, (currentPoint.getY() * magnificationFactor) + disY, 10, 10);

        currentPoint = (Point) mazeGraph.getNodeData(nodeNum - 1);
        g2.fillOval((currentPoint.getX() * magnificationFactor) + disX, (currentPoint.getY() * magnificationFactor) + disY, 10, 10);
/*
        g.setColor(Color.WHITE);
        g.drawLine(0, 100, 500, 100);
        g.drawLine(0, 100 + wallSpacing, 500, 100 + wallSpacing);
*/
    }
}
