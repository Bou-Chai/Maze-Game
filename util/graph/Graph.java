// Connected Weighted Graph
// Tyseer Ammar Shahriar
// Date created: August 16, 2024
// Date last updated: December 18, 2024
package util.graph;

import java.util.ArrayList;

public class Graph<T> {
    // Define variables
    private ArrayList<Node> adjacencyList = new ArrayList<Node>();

    // Constructor that initializes initial node
    public Graph(T data) {
        adjacencyList.add(new Node(data));
    }

    // Method to add unconnected node
    public void addNode(T data) {
        adjacencyList.add(new Node(data));
    }

    // Method to add node connected to another node
    public void addNode(T data, int node, int weight) {
        adjacencyList.add(new Node(data));
        addEdge(node, adjacencyList.size() - 1, weight);
    }

    // Method to add an edge between the specified nodes
    public void addEdge(int node1, int node2, int weight) {
        adjacencyList.get(node1).addEdge(node2, weight);
        adjacencyList.get(node2).addEdge(node1, weight);
    }

    // Method to return a node
    public Node getNode(int index) {
        return adjacencyList.get(index);
    }

    // Setters
    public void setNodeData(int node, T data) {
        getNode(node).setData(data);
    }
}
