import java.util.*;
class Wall {
    private final List<Brick> bricks = new ArrayList<>();
    public boolean isFull() { return bricks.size() >= 90; }
    public void addBrick(Brick b) { bricks.add(b); }
    public List<Brick> getBricks() { return bricks; }
}