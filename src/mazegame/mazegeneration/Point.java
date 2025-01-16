// Tyseer Ammar Shahriar
// Class defining nodes
// Date created: August 30, 2024
// Date last updated: January 6, 2025

package mazegame.mazegeneration;

public class Point {
    // Declare variables
    int x;
    int y;

    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to check of two points are equal
    public boolean equals(Point point) {
        if (x == point.x && y == point.y) {
            return true;
        } else {
            return false;
        }
    }

    // Method to print point
    public void print() {
        System.out.printf("(%d, %d)", x, y);
        System.out.println();
    }

    // Method to add two points together
    public void add(Point point) {
        x += point.getX();
        y += point.getY();
    }

    public void addX(int x) {
        this.x += x;
    }

    public void addY(int y) {
        this.y += y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
