// Tyseer Ammar Shahriar
// Class defining nodes
// Date created: August 30, 2024
// Date last updated: August 30, 2024

class Point {
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
}
