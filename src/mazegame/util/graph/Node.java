// Node class for graph
// Tyseer Ammar Shahriar
// Date created: December 18, 2024
// Date last updated: January 6, 2025
package mazegame.util.graph;

import java.util.ArrayList;

public class Node<T> {
    private T data;
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Edge edge) {
        this.data = data;
        edges.add(edge);
    }

    // Method to add edge
    public void addEdge(int nodeIndex, int weight) {
        edges.add(new Edge(nodeIndex, weight));
    }

    // Method to print node
    public void print() {
        for (Edge edge: edges) {
            System.out.printf("(%d:%d) ", edge.getNodeIndex(), edge.getWeight());
        }
    }

    // Getters
    public T getData() {
        return data;
    }

    public Edge getEdge(int i) {
        return edges.get(i);
    }

    public int getNumEdges() {
        return edges.size();
    }

    // Setters
    public void setData(T data) {
        this.data = data;
    }
}
