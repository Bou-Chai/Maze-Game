// Class defining entities
// Tyseer Ammar Shahriar
// Date created: January 22, 2025
// Date last updated: January 22, 2025

package mazegame.entities;

class Entity {
    int x;
    int y;
    int radius;

    Entity() {
        
    }

    Entity(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
