import java.util.*;

public class BrickService {
    // Stores all bricks using their unique ID as key
    private final Map<Integer, Brick> allBricks = new HashMap<>();

    // Reference to the wall service to manage city-wise walls
    private final WallService wallService;

    public BrickService(WallService wallService) {
        this.wallService = wallService;
    }

    // Creates a new brick and adds it to the wall of the specified city
    public void createBrick(String city, String caption, String msg, User owner, String dedicatee) {
        Brick brick = new Brick(caption, msg, owner, dedicatee);
        wallService.addBrickToCity(city, brick);
        allBricks.put(brick.getId(), brick); 
    }

    // Adds a comment to a specific brick by its ID
    public void addComment(int id, String comment) {
        Brick b = allBricks.get(id);
        if (b != null) b.addComment(comment); 
    }

    // Flags a brick for review (maybe inappropriate or incorrect content)
    public void flagBrick(int id) {
        Brick b = allBricks.get(id);
        if (b != null) b.addFlag(); 
    }

    // Allows the owner of a brick to edit their own content
    public void editBrick(int id, User user, String caption, String msg) {
        Brick b = allBricks.get(id);
        if (b != null && b.getOwner().getId() == user.getId()) b.edit(caption, msg);
    }

    // Admins can freely edit any brick, regardless of who owns it
    public void editBrickAsAdmin(int id, String caption, String msg) {
        Brick b = allBricks.get(id);
        if (b != null) b.edit(caption, msg);
    }

    // Shows which dedicatee received the most and least love (based on visible bricks)
    public void showPopularityStats() {
        Map<String, Integer> countMap = new HashMap<>();

        // Count visible bricks per dedicatee
        for (Brick b : allBricks.values()) {
            if (b.isVisible())
                countMap.put(b.getDedicatee(), countMap.getOrDefault(b.getDedicatee(), 0) + 1);
        }

        String hottest = null, coldest = null;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // Find the most and least dedicated-to person
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                hottest = entry.getKey();
            }
            if (entry.getValue() < min) {
                min = entry.getValue();
                coldest = entry.getKey();
            }
        }

        // Display the popularity stats
        System.out.println("Most Loved: " + (hottest != null ? hottest : "None"));
        System.out.println("Least Loved: " + (coldest != null ? coldest : "None"));
    }
}