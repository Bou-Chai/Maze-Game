// Edge class for graph
// Tyseer Ammar Shahriar
// Date created: December 18, 2024
// Date last updated: January 6, 2025
package mazegame.util.graph;

class Edge {
    private int nodeIndex;
    private int weight;

    public Edge(int nodeIndex, int weight) {
        this.nodeIndex = nodeIndex;
        this.weight = weight;
    }

    // Getters
    public int getNodeIndex() {
        return nodeIndex;
    }

    public int getWeight() {
        return weight;
    }

    // Setters
    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
