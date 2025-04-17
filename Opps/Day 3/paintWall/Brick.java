import java.util.*;
class Brick {
    private static int idCounter = 1;
    private final int id;
    private String caption, message;
    private final User owner;
    private final String dedicatee;
    private final List<String> comments = new ArrayList<>();
    private int flags = 0;
    private boolean visible = true;

    public Brick(String caption, String msg, User owner, String dedicatee) {
        this.id = idCounter++;
        this.caption = caption;
        this.message = msg;
        this.owner = owner;
        this.dedicatee = dedicatee;
    }
    // add cmt
    public void addComment(String comment) { comments.add(comment); }
    //if repr is grt then 10
    public void addFlag() { if (++flags >= 10) visible = false; }
    //make is hidden
    public boolean isVisible() { return visible; }
    //getter
    public int getId() { return id; }
   
    public User getOwner() { return owner; }
    public String getDedicatee() { return dedicatee; }

    public void edit(String caption, String msg) {
        this.caption = caption;
        this.message = msg;
    }
    //print brick
    public void display(boolean highlight) {
        if (!visible) return;
        String border = highlight ? "*".repeat(40) : "-".repeat(40);
        System.out.println(border);
        System.out.println("ID: " + id + " | To: " + dedicatee + " | From: " + owner.getName());
        System.out.println("Caption: " + caption);
        System.out.println("Message: " + message);
        System.out.println("Comments: " + comments);
        System.out.println(border);
    }
}