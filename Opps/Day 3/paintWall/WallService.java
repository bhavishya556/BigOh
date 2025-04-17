import java.util.*;

class WallService {
    // Map to store walls for each city
    private final Map<String, List<Wall>> cityWalls = new HashMap<>();

    // Constructor initializes walls for some default cities
    public WallService() {
        cityWalls.put("Delhi", new ArrayList<>(List.of(new Wall())));
        cityWalls.put("Mumbai", new ArrayList<>(List.of(new Wall())));
        cityWalls.put("Bangalore", new ArrayList<>(List.of(new Wall())));
    }

    // Displays all available cities where users can paint bricks
    public void showCities() {
        System.out.println("Available cities: " + cityWalls.keySet());
    }

    // Adds a brick to the appropriate city's wall
    public void addBrickToCity(String city, Brick brick) {
        city = capitalize(city); // Standardize city name format
        List<Wall> walls = cityWalls.get(city);

        if (walls == null) {
            System.out.println("City not found!");
            return;
        }

        Wall wall = walls.get(walls.size() - 1); // Get the latest wall

        // If current wall is full, create a new wall
        if (wall.isFull()) {
            wall = new Wall();
            walls.add(wall);
        }

        wall.addBrick(brick); // Add brick to the current wall
    }

    // Shows all bricks on a city wall, highlighting if the viewer is the owner
    public void viewCityWall(String city, User viewer) {
        city = capitalize(city); // Ensure proper casing
        List<Wall> walls = cityWalls.get(city);

        if (walls == null) {
            System.out.println("City not found!");
            return;
        }

        // Go through each wall and show bricks
        for (Wall wall : walls) {
            for (Brick brick : wall.getBricks()) {
                brick.display(brick.getOwner().getId() == viewer.getId());
            }
        }
    }

    // Shows number of walls and bricks per city (useful for admin stats)
    public void showStats() {
        cityWalls.forEach((city, walls) -> {
            HotelSystem.out.println(city + " has " + walls.size() + " wall(s).");
            for (int i = 0; i < walls.size(); i++) {
                HotelSystem.out.println("Wall " + (i + 1) + " has " + walls.get(i).getBricks().size() + " bricks.");
            }
        });
    }

    // Helper method to standardize city name 
    private String capitalize(String city) {
        if (city == null || city.isEmpty()) return city;
        return city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
    }
}
