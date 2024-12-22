// Node class for graph
// Tyseer Ammar Shahriar
// Date created: December 18, 2024
// Date last updated: December 22, 2024
package util.graph;

import java.util.ArrayList;

class Node<T> {
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

    // Getters
    public T getData() {
        return data;
    }

    // Setters
    public void setData(T data) {
        this.data = data;
    }
}