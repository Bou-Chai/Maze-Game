// Connected Weighted Graph
// Tyseer Ammar Shahriar
// Date created: August 16, 2024
// Date last updated: January 6, 2025
package mazegame.util.graph;

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

    // Method to get node data
    public T getNodeData(int index) {
        return (T) adjacencyList.get(index).getData();
    }

    // Mehtod to return node index of the first occurence of the given data
    public int getNodeIndex(T data) {
        T listData;
        for (int i = 0; i < adjacencyList.size(); i++) {
            listData = (T) adjacencyList.get(i).getData();
            if (listData == data) {
                return i;
            }
        }
        // Return -1 upon failure to find matching item
        return -1;
    }

    // Mehtod to return node index of the first occurence of the given data
    public int getNodeIndex(T data, Comparison comparator) {
        T listData;
        for (int i = 0; i < adjacencyList.size(); i++) {
            //System.out.println(i);
            listData = (T) adjacencyList.get(i).getData();
            if (comparator.compare(listData, data) == 0) {
                return i;
            }
        }
        // Return -1 upon failure to find matching item
        return -1;
    }

    // Mehtod to return node index of the first occurence of the given data (But searches in reverse order)
    public int getNodeIndexR(T data, Comparison comparator) {
        T listData;
        for (int i = adjacencyList.size() - 1; -1 < i; i--) {
            //System.out.println(i);
            listData = (T) adjacencyList.get(i).getData();
            if (comparator.compare(listData, data) == 0) {
                return i;
            }
        }
        // Return -1 upon failure to find matching item
        return -1;
    }

    // Method to get number of nodes
    public int getNumNodes() {
        return adjacencyList.size();
    }

    // Method to print the graph
    public void print() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.printf("%d: ", i);
            adjacencyList.get(i).print();
            System.out.println();
        }
    }

    // Method to print the graph data (References)
    public void printR() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(adjacencyList.get(i));
        }
    }

    // Setters
    public void setNodeData(int node, T data) {
        getNode(node).setData(data);
    }
}
