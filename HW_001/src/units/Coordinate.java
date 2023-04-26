package units;

public class Coordinate {
    protected int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public float distance(Coordinate coordinate){
        float dx = coordinate.x - this.x;
        float dy = coordinate.y - this.y;
        return (float) Math.sqrt(dx*dx+dy*dy);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
