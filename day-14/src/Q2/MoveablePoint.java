package Q2;

public class MoveablePoint implements Moveable {
    // Attributes
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    // Constructor
    public MoveablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        setY(getY() + getySpeed());
    }

    @Override
    public void moveDown() {
        setY(getY() - getySpeed());
    }

    @Override
    public void moveLeft() {
        setX(getX() - getxSpeed());
    }

    @Override
    public void moveRight() {
        setX(getX() + getxSpeed());
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    // toString
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
