import java.util.Objects;

public class Position {
    int x, y;

    Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.getX() && y == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null) return false;
//        if (getClass() != o.getClass()) return false;
//        Position p = (Position) o;
//        return x == p.getX() && y == p.getY();
//    }
}