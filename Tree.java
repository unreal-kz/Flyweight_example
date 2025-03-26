// Flyweight Interface
public interface Tree {
    void draw(int x, int y); // extrinsic state
}

// Concrete Flyweight
public class OakTree implements Tree {
    private final String type = "Oak";
    private final String color = "Green";
    private final String texture = "Rough";

    public void draw(int x, int y) {
        System.out.println("Drawing " + type + " tree at (" + x + ", " + y + ")");
    }
}

// Flyweight Factory
public class TreeFactory {
    private static final Map<String, Tree> trees = new HashMap<>();

    public static Tree getTree(String key) {
        trees.putIfAbsent(key, new OakTree());
        return trees.get(key);
    }
}

// Client
public class Forest {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Tree tree = TreeFactory.getTree("Oak");
            tree.draw(randomX(), randomY());
        }
    }
}
